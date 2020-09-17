package com.depromeet.tmp.user.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.depromeet.tmp.user.dto.UserSignUpRequest;
import com.depromeet.tmp.user.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("signUp")
	public ResponseEntity<Object> signUp(@Valid UserSignUpRequest userSignUpRequest, BindingResult bindingResult) {
		if (userService.hasErrors(userSignUpRequest, bindingResult)) {
			return new ResponseEntity<>("회원가입 시 빈 입력 칸이 없어야 합니다.", HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(userService.signUp(userSignUpRequest), HttpStatus.OK);
	}

}
