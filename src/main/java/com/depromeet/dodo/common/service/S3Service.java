package com.depromeet.dodo.common.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.transfer.MultipleFileUpload;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.TransferManagerBuilder;
import com.depromeet.dodo.common.dto.S3UploadImage;
import com.depromeet.dodo.common.exception.AwsS3SaveFailedException;
import com.depromeet.dodo.config.AWSConfig;
import com.depromeet.dodo.image.domain.Image;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
@PropertySource("classpath:aws.properties")
public class S3Service {

	private final AWSConfig awsConfig;

	@Value("${cloud.aws.s3.bucket}")
	private String bucket;

	@Value("${aws.file.path}")
	private String filePath;

	@SneakyThrows
	public String uploadFile(MultipartFile file, String fileName) {
		AmazonS3 s3Client = awsConfig.AwsS3Client();

		ObjectMetadata metaData = new ObjectMetadata();
		metaData.setContentLength(file.getBytes().length);

		try {
			s3Client.putObject(new PutObjectRequest(bucket, fileName, file.getInputStream(), metaData)
				.withCannedAcl(CannedAccessControlList.PublicRead));
		} catch (AmazonS3Exception | IOException e) {
			throw new AwsS3SaveFailedException(e);
		}

		return getUrl(bucket, fileName);
	}

	public String getUrl(String path, String fileName) {
		AmazonS3 s3Client = awsConfig.AwsS3Client();
		return s3Client.getUrl(path, fileName).toString();
	}

	public List<S3UploadImage> uploadFiles(String folderName, List<S3UploadImage> s3UploadImages) {
		List<File> files = new ArrayList<>();
		s3UploadImages.stream()
			.forEach(x -> files.add(convert(x.getProfileImage().getImageFile(), x.getFileName())
				.orElseThrow(() -> new IllegalArgumentException("MultipartFile -> File로 전환이 실패했습니다."))));

		List<String> filePaths = s3UploadFileList(folderName, files);
		filePaths.stream().forEach(x -> s3UploadImages.get(filePaths.indexOf(x)).setFilePath(x));
		return s3UploadImages;
	}

	@SneakyThrows
	private List<String> s3UploadFileList(String folderName, List<File> files) {
		AmazonS3 s3Client = awsConfig.AwsS3Client();
		TransferManager xfer_mgr = TransferManagerBuilder.standard()
			.withS3Client(s3Client)
			.build();

		MultipleFileUpload xfer = xfer_mgr.uploadFileList(bucket, folderName, new File(filePath), files);

		try {
			xfer.waitForCompletion();
			xfer.waitForException();
		} catch (InterruptedException e) {
			throw new AwsS3SaveFailedException(e);
		} finally {
			files.stream().forEach(x -> x.delete());
			xfer_mgr.shutdownNow();
		}

		List<String> filesUrl = new ArrayList<>();
		files.stream().forEach(x -> filesUrl.add(getUrl(bucket.concat("/" + folderName), x.getName())));
		return filesUrl;
	}

	@SneakyThrows
	private Optional<File> convert(MultipartFile file, String fileName) {
		File convertFile = new File(fileName);
		try {
			if (convertFile.createNewFile()) {
				try (FileOutputStream fos = new FileOutputStream(convertFile)) {
					fos.write(file.getBytes());
				}
				return Optional.of(convertFile);
			}
		} catch (IOException e) {
			throw new AwsS3SaveFailedException("MultipartFile -> File로 전환이 실패했습니다.", e);
		}

		return Optional.empty();
	}

	public void deleteS3Object(String path, Image image) {
		AmazonS3 s3Client = awsConfig.AwsS3Client();
		s3Client.deleteObject(new DeleteObjectRequest(path, image.getFileName()));
	}

}
