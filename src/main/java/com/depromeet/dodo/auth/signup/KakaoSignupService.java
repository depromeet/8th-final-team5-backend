package com.depromeet.dodo.auth.signup;

import org.springframework.stereotype.Service;

import com.depromeet.dodo.auth.thirdparty.kakao.api.KakaoAuthApiService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class KakaoSignupService implements SignupService {

	final private KakaoAuthApiService kakaoAuthApiService;

	@Override
	public void signup() {
	}

}
