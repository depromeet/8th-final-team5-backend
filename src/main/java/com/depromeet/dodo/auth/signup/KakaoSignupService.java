package com.depromeet.dodo.auth.signup;

import org.springframework.stereotype.Service;

import com.depromeet.dodo.auth.thirdparty.kakao.api.KakaoAuthApiService;
import com.depromeet.dodo.auth.thirdparty.kakao.request.KakaoSignInRequest;
import com.depromeet.dodo.auth.thirdparty.kakao.response.KakaoProfileResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class KakaoSignupService {

	private final KakaoAuthApiService kakaoAuthApiService;

	public KakaoProfileResponse signup(KakaoSignInRequest kakaoSignInRequest) {
		return kakaoAuthApiService.getKaKaoProfile(kakaoSignInRequest.getToken());
	}

}
