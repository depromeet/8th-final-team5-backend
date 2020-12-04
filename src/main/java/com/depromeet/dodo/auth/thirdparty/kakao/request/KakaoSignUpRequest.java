package com.depromeet.dodo.auth.thirdparty.kakao.request;

import org.springframework.web.multipart.MultipartFile;

import com.depromeet.dodo.auth.common.dto.SignUpRequest;
import com.vividsolutions.jts.geom.Point;

import lombok.Getter;

@Getter
public class KakaoSignUpRequest extends SignUpRequest {

	private String token;

	public KakaoSignUpRequest(String username, int age, Point address, String introduce, PetInfo petInfo,
		String token, MultipartFile profileImage) {
		super(username, age, address, introduce, petInfo, profileImage);
		this.token = token;
	}
}
