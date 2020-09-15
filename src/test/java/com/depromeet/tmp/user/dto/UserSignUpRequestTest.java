package com.depromeet.tmp.user.dto;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserSignUpRequestTest {

	private static UserSignUpRequest user1;
	private static UserSignUpRequest user2;
	private static UserSignUpRequest user3;
	private static UserSignUpRequest user4;

	@BeforeAll
	static void setup() {
		user1 = new UserSignUpRequest("email", "password", "password");
		user2 = new UserSignUpRequest("email", "password1", "password2");
		user3 = new UserSignUpRequest("email", null, "password");
		user4 = new UserSignUpRequest(null, "password", "password");
	}

	@Test
	@DisplayName("회원가입 validate() 확인")
	void validate() {
		assertThrows(NullPointerException.class, () -> user3.validate());
		assertThrows(NullPointerException.class, () -> user4.validate());
		assertThat(user1.validate(), is(equalTo(true)));
		assertThat(user2.validate(), is(equalTo(false)));
	}

}