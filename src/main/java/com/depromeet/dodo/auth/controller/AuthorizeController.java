package com.depromeet.dodo.auth.controller;

import com.depromeet.dodo.auth.common.UserInfo;
import com.depromeet.dodo.auth.thirdparty.naver.NaverAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthorizeController {

	private final NaverAuthService naverAuthService;

	@GetMapping("/third-parties/naver/users")
	public UserInfo getKakaoUserInfo(@RequestParam String token) {

		return naverAuthService.getUserInfo(null, token);
	}
}
