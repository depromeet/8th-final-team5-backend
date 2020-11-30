package com.depromeet.dodo.common.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.depromeet.dodo.common.dto.ImageWithPriority;
import com.depromeet.dodo.common.dto.ProfileImage;
import com.depromeet.dodo.common.dto.S3UploadImage;
import com.depromeet.dodo.image.domain.Image;
import com.depromeet.dodo.image.service.ImageService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FileUploadService {

	private final S3Service s3Service;
	private final ImageService imageService;

	public Image singleFileUpload(MultipartFile file) {
		String fileName = makeFileName(file.getOriginalFilename());
		Image image = new Image(s3Service.uploadFile(file, fileName), fileName);
		return image;
	}

	public List<ImageWithPriority> multiFileUpload(List<ProfileImage> files) {
		List<S3UploadImage> s3UploadImages = new ArrayList<>();
		String folderName = UUID.randomUUID().toString();
		files.stream().forEach(x -> s3UploadImages.add(new S3UploadImage(x, folderName,
			makeFileName(x.getImageFile().getOriginalFilename()))));

		List<S3UploadImage> uploadImages = s3Service.uploadFiles(folderName, s3UploadImages);
		return addImageList(uploadImages);
	}

	private List<ImageWithPriority> addImageList(List<S3UploadImage> uploadImages) {
		List<Image> images = new ArrayList<>();
		List<ImageWithPriority> imageWithPriority = new ArrayList<>();

		uploadImages.stream()
			.forEach(x -> {
				Image image = new Image(x.getFilePath(), x.getFileName());
				images.add(image);
				imageWithPriority.add(new ImageWithPriority(image, x.getProfileImage().getPriority()));
			});

		imageService.addImages(images);
		return imageWithPriority;
	}

	private String makeFileName(String fileName) {
		return fileName.concat(UUID.randomUUID().toString());
	}

}
