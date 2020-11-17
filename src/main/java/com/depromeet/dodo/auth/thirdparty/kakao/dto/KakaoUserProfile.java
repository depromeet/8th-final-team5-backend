package com.depromeet.dodo.auth.thirdparty.kakao.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class KakaoUserProfile {
	private String id;
	private String name;
	private String email;
	private String gender;
	private String profileImage;
}
