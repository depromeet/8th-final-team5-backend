package com.depromeet.dodo.auth.controller;

import com.depromeet.dodo.auth.common.UserInfo;
import com.depromeet.dodo.auth.thirdparty.naver.NaverAuthService;
import io.swagger.annotations.ApiOperation;
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
	@ApiOperation("네이버 유저의 정보를 가져오는 API")
	public UserInfo getNaverUserInfo(@RequestParam String token) {
		return naverAuthService.getUserInfo(null, token);
	}

}
