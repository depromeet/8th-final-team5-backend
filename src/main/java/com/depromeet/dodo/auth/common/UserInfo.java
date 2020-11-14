package com.depromeet.dodo.auth.common;

import com.depromeet.dodo.user.Gender;
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
