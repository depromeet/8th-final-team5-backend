package com.depromeet.dodo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
@PropertySource("classpath:aws.properties")
public class AWSConfig {

	@Value("${cloud.aws.credentials.accessKey}")
	private String accessKey;

	@Value("${cloud.aws.credentials.secretKey}")
	private String secretKey;

	@Value("${cloud.aws.region.static}")
	private String region;

	@Bean
	public BasicAWSCredentials basicAWSCredentials() {
		return new BasicAWSCredentials(accessKey, secretKey);
	}

	@Bean
	public AWSCredentialsProvider awsCredentialsProvider(AWSCredentials awsCredentials) {
		return new AWSCredentialsProvider() {
			@Override
			public AWSCredentials getCredentials() {
				return awsCredentials;
			}

			@Override
			public void refresh() {
			}

		};
	}

	@Bean
	public AmazonS3 amazonS3Client(AWSCredentialsProvider awsCredentialsProvider) {
		return AmazonS3ClientBuilder
			.standard()
			.withCredentials(awsCredentialsProvider)
			.withRegion(this.region)
			.build();
	}

}
