package com.depromeet.tmp.user.controller;

import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.depromeet.tmp.user.domain.User;
import com.depromeet.tmp.user.dto.UserSignUpRequest;
import com.depromeet.tmp.user.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("signUp")
	public ResponseEntity<User> signUp(UserSignUpRequest userSignUpRequest) {
		if(!userSignUpRequest.validate() || Objects.nonNull(userService.findByEmail(userSignUpRequest.getEmail()))) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(userService.signUp(userSignUpRequest), HttpStatus.OK);
	}

}
