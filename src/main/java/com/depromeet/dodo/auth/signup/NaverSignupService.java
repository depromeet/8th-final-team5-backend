package com.depromeet.dodo.auth.signup;

import org.springframework.stereotype.Service;

import com.depromeet.dodo.auth.thirdparty.naver.api.NaverAuthApiService;
import com.depromeet.dodo.auth.thirdparty.naver.dto.NaverUserProfile;
import com.depromeet.dodo.auth.thirdparty.naver.request.NaverSignUpRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NaverSignupService {

	private final NaverAuthApiService naverAuthApiService;

	public NaverUserProfile signup(NaverSignUpRequest naverSignUpRequest) {
		return naverAuthApiService.getNaverProfile(naverSignUpRequest.getToken());
	}

}
