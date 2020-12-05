package com.depromeet.dodo.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class S3UploadImage {
	private ProfileImage profileImage;
	private String fileName;
	private String filePath;
	private String folderName;

	public S3UploadImage(ProfileImage profileImage, String folderName, String fileName) {
		this.profileImage = profileImage;
		this.folderName = folderName;
		this.fileName = fileName;
	}
}
