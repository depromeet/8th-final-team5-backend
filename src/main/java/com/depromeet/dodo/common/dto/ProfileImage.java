package com.depromeet.dodo.common.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProfileImage {
	private MultipartFile imageFile;
	private int priority;
}

