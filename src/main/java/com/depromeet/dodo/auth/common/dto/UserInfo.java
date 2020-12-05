package com.depromeet.dodo.auth.common.dto;

import com.depromeet.dodo.common.dto.Gender;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserInfo {

	private String name;
	private Gender gender;
	private Integer age;
	private String profileImageUrl;
}
