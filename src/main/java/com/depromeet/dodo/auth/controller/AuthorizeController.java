package com.depromeet.dodo.auth.controller;

import com.depromeet.dodo.auth.common.UserInfo;
import com.depromeet.dodo.auth.thirdparty.naver.NaverAuthService;
import com.depromeet.dodo.auth.thirdparty.naver.request.NaverSignUpRequest;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.depromeet.dodo.common.response.ResponseEntityConstants.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthorizeController {

	private final NaverAuthService naverAuthService;

	@GetMapping("/third-parties/naver/users")
	@ApiOperation("네이버 유저의 정보를 가져오는 API")
	public UserInfo getNaverUserInfo(@RequestParam String token) {
		return naverAuthService.getUserInfo(null, token);
	}

	@PostMapping("/third-parties/naver/sign-up")
	@ApiOperation("네이버로 회원가입하기")
	public ResponseEntity<Void> naverSignUp(@RequestBody NaverSignUpRequest signUpRequest) {
		naverAuthService.signUp(signUpRequest);

		return CREATED;
	}
}
