package com.depromeet.dodo.auth.thirdparty.kakao.request;

import com.depromeet.dodo.auth.common.SignUpRequest;

import lombok.Getter;

@Getter
public class KakaoSignUpRequest extends SignUpRequest {

	private String token;

	public KakaoSignUpRequest(String username, int age, String address, String introduce, PetInfo petInfo,
		String token) {
		super(username, age, address, introduce, petInfo);
		this.token = token;
	}
}
