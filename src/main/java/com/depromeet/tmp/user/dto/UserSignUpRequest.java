package com.depromeet.tmp.user.dto;

import java.util.Objects;

import com.depromeet.tmp.user.domain.User;
import com.depromeet.tmp.util.EncryptionUtils;

public class UserSignUpRequest {

	private String email;

	private String password1;

	private String password2;

	private UserSignUpRequest() {
	}

	public UserSignUpRequest(String email, String password1, String password2) {
		this.email = email;
		this.password1 = password1;
		this.password2 = password2;
	}

	public boolean validate() {
		Objects.requireNonNull(this.email, "email이 비었습니다.");
		Objects.requireNonNull(this.password1, "password1이 비었습니다.");
		Objects.requireNonNull(this.password2, "password2가 비었습니다.");
		return Objects.equals(this.password1, this.password2);
	}

	public User toEntityWithPasswordEncoder() {
		return new User(this.email, EncryptionUtils.encryptSHA256(this.password1));
	}

	public String getEmail() {
		return email;
	}

	public String getPassword1() {
		return password1;
	}

	public String getPassword2() {
		return password2;
	}

}
