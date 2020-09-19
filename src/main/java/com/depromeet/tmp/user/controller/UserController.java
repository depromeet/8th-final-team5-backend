package com.depromeet.tmp.user.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.depromeet.tmp.common.exception.DuplicateEmailException;
import com.depromeet.tmp.user.domain.User;
import com.depromeet.tmp.user.dto.UserSignUpRequest;
import com.depromeet.tmp.user.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("signUp")
	public ResponseEntity<User> signUp(@Valid UserSignUpRequest userSignUpRequest) {
		if(userService.findByEmail(userSignUpRequest.getEmail()) != null) {
			throw new DuplicateEmailException("이미 사용 중인 이메일입니다.");
		}

		return new ResponseEntity<>(userService.signUp(userSignUpRequest), HttpStatus.OK);
	}

}
