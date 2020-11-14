package com.depromeet.dodo.auth.thirdparty.kakao.request;

import com.depromeet.dodo.auth.thirdparty.ThirdPartyRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class KakaoSignInRequest implements ThirdPartyRequest {

	private String kakaoId;

	private String token;

	@Override
	public String getPrincipal() {
		return kakaoId;
	}

	@Override
	public String getCredential() {
		return token;
	}
}
