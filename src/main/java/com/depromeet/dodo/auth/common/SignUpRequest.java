package com.depromeet.dodo.auth.common;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.depromeet.dodo.common.dto.Gender;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignUpRequest {

	private String username;
	private int age;
	private String address;
	private String introduce;
	private PetInfo petInfo;
	private MultipartFile profileImage;

	@AllArgsConstructor
	@Getter
	public static class PetInfo {
		private String name;
		private Gender gender;
		private int age;
		private String breed;
		private boolean fixing;
		private boolean vaccination;
		private Map<Integer, MultipartFile> profileImage;
	}

}
