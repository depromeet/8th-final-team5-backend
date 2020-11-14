package com.depromeet.dodo.auth.thirdparty.kakao.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Getter;

@Getter
public class KakaoAccount {

	private Profile profile;
	private String email;
	private String gender;

	@Getter
	@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
	public static class Profile {
		private String nickName;
		private String profileImageUrl;
	}
}
