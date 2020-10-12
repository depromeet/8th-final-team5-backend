package com.depromeet.dodo.auth.thirdparty.kakao.api;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.depromeet.dodo.auth.thirdparty.kakao.response.KakaoProfileResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class KakaoAuthApiService {

	// kakao api 문서 : https://developers.kakao.com/docs/latest/ko/kakaologin/rest-api#req-user-info
	private static final String KAKAO_PROFILE_URL = "https://kapi.kakao.com/v2/user/me";

	private final WebClient apiWebClient;

	public KakaoProfileResponse getKaKaoProfile(String token) {
		return apiWebClient.get()
			.uri(KAKAO_PROFILE_URL)
			.headers(headers -> headers.setBearerAuth(token))
			.retrieve()
			.onStatus(status -> status.is4xxClientError(),
				response -> response.bodyToMono(KakaoErrorResponse.class)
					.map(body -> new IllegalArgumentException(body.getMsg())))
			.bodyToMono(KakaoProfileResponse.class)
			.block();
	}

	@Getter
	@AllArgsConstructor
	public static class KakaoErrorResponse {
		private int code;
		private String msg;
	}

}
