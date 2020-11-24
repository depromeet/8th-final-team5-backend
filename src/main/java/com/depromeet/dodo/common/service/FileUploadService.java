package com.depromeet.dodo.common.service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.depromeet.dodo.image.domain.Image;
import com.depromeet.dodo.image.service.ImageService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FileUploadService {
	private static final Integer SINGLE_FILE_PRIORITY = 0;

	private final S3Service s3Service;
	private final ImageService imageService;

	public Image singleFileUpload(MultipartFile file) {
		String fileName = UUID.randomUUID().toString();
		Image image = new Image(s3Service.upload(file, fileName), fileName, SINGLE_FILE_PRIORITY);
		imageService.addImage(image);

		return image;
	}

	public List<Image> multiFileUpload(Map<Integer, MultipartFile> files) {
		List<Image> images = files.entrySet()
			.stream()
			.map(x -> {
				String fileName = UUID.randomUUID().toString();
				Image image = new Image(s3Service.upload(x.getValue(), fileName), fileName, x.getKey());
				imageService.addImage(image);
				return image;
			})
			.collect(Collectors.toList());

		return images;
	}

}
