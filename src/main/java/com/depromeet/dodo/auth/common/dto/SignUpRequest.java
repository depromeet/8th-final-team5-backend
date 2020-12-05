package com.depromeet.dodo.auth.common.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.depromeet.dodo.common.dto.Gender;
import com.depromeet.dodo.common.dto.ProfileImage;
import com.depromeet.dodo.petInfo.domain.Breed;
import com.depromeet.dodo.petInfo.domain.Charact;
import com.depromeet.dodo.petInfo.domain.Interest;
import com.vividsolutions.jts.geom.Point;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignUpRequest {

	private String username;
	private int age;
	private Point address;
	private String introduce;
	private PetInfo petInfo;
	private MultipartFile profileImage;

	@Getter
	@AllArgsConstructor
	public static class PetInfo {
		private String name;
		private Gender gender;
		private int age;
		private Breed breed;
		private List<Interest> interests;
		private List<Charact> characters;
		private boolean fixing;
		private boolean vaccination;
		private List<ProfileImage> profileImages;
	}

}
