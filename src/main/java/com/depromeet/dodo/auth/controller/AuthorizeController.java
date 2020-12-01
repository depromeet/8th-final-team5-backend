package com.depromeet.dodo.auth.controller;

import static com.depromeet.dodo.common.response.ResponseEntityConstants.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.depromeet.dodo.auth.common.dto.UserInfo;
import com.depromeet.dodo.auth.thirdparty.kakao.request.KakaoSignInRequest;
import com.depromeet.dodo.auth.thirdparty.kakao.request.KakaoSignUpRequest;
import com.depromeet.dodo.auth.thirdparty.kakao.service.KakaoAuthService;
import com.depromeet.dodo.auth.thirdparty.naver.request.NaverSignInRequest;
import com.depromeet.dodo.auth.thirdparty.naver.request.NaverSignUpRequest;
import com.depromeet.dodo.auth.thirdparty.naver.service.NaverAuthService;
import com.depromeet.dodo.common.service.S3Service;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthorizeController {

	private final NaverAuthService naverAuthService;
	private final KakaoAuthService kakaoAuthService;

	private final S3Service s3Service;

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

	@GetMapping("/third-parties/kakao/users")
	@ApiOperation("카카오 유저의 정보를 가져오는 API")
	public UserInfo getKakaoUserInfo(@RequestParam String token) {
		return kakaoAuthService.getUserInfo(null, token);
	}

	@PostMapping("/third-parties/kakao/sign-up")
	@ApiOperation("카카오로 회원가입하기")
	public ResponseEntity<Void> kakaoSignUp(@RequestBody KakaoSignUpRequest signUpRequest) {
		kakaoAuthService.signUp(signUpRequest);
		return CREATED;
	}

	@PostMapping("/third-parties/kakao/sign-in")
	@ApiOperation("카카오로 로그인하기")
	public ResponseEntity<Void> kakaoLogin(@RequestBody KakaoSignInRequest signInRequest) {
		kakaoAuthService.signIn(signInRequest);
		return OK;
	}

	@PostMapping("/third-parties/naver/sign-in")
	@ApiOperation("네이버로 로그인하기")
	public ResponseEntity<Void> naverLogin(@RequestBody NaverSignInRequest signInRequest) {
		naverAuthService.signIn(signInRequest);
		return OK;
	}

}
