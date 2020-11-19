package com.depromeet.dodo.auth.thirdparty.kakao.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.sun.istack.NotNull;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class KakaoProfileResponse {

	@NotNull
	private Long id;

	private KakaoAccount kakaoAccount;

	@JsonCreator
	public KakaoProfileResponse(
		@JsonProperty("id") Long id,
		@JsonProperty("kakao_account") KakaoAccount kakaoAccount) {
		this.id = id;
		this.kakaoAccount = kakaoAccount;
	}

	public String getId() {
		return id.toString();
	}

	public KakaoAccount getKakaoAccount() {
		return kakaoAccount;
	}

}
