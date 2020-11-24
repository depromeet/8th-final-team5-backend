package com.depromeet.dodo.common.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.depromeet.dodo.common.exception.AwsS3SaveFailedException;
import com.depromeet.dodo.config.AWSConfig;
import com.depromeet.dodo.image.domain.Image;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@Service
@RequiredArgsConstructor
@PropertySource("classpath:aws.properties")
public class S3Service {

	private final AWSConfig awsConfig;

	@Value("${cloud.aws.s3.bucket}")
	private String bucket;

	@SneakyThrows
	public String upload(MultipartFile file, String fileName) {
		AmazonS3 s3Client = awsConfig.amazonS3Client(awsConfig.awsCredentialsProvider(awsConfig.basicAWSCredentials()));
		try {
			s3Client.putObject(new PutObjectRequest(bucket, fileName, file.getInputStream(), null)
				.withCannedAcl(CannedAccessControlList.PublicRead));
		} catch (IOException e) {
			throw new AwsS3SaveFailedException("AWS S3 이미지 저장에 실패했습니다. : ".concat(e.toString()));
		}

		return s3Client.getUrl(bucket, fileName).toString();
	}

	public void delete(Image image) {
		AmazonS3 s3Client = awsConfig.amazonS3Client(awsConfig.awsCredentialsProvider(awsConfig.basicAWSCredentials()));
		s3Client.deleteObject(new DeleteObjectRequest(bucket, image.getFileName()));
	}

}
