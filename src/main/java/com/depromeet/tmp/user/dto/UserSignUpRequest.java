package com.depromeet.tmp.user.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserSignUpRequest {

	@Email(message = "이메일 형식에 맞지 않습니다.")
	@NotBlank(message = "email이 비었습니다.")
	private String email;

	@NotBlank(message = "password가 비었습니다.")
	private String password;

}
