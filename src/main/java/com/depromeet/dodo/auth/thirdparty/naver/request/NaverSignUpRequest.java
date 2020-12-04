package com.depromeet.dodo.auth.thirdparty.naver.request;

import org.springframework.web.multipart.MultipartFile;

import com.depromeet.dodo.auth.common.dto.SignUpRequest;
import com.vividsolutions.jts.geom.Point;

import lombok.Getter;

@Getter
public class NaverSignUpRequest extends SignUpRequest {

	private String token;

	public NaverSignUpRequest(String username, int age, Point address, String introduce, PetInfo petInfo,
		String token, MultipartFile profileImage) {
		super(username, age, address, introduce, petInfo, profileImage);
		this.token = token;
	}
}
