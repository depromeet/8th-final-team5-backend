package com.depromeet.dodo.auth.login;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.depromeet.dodo.auth.exception.AccessDeniedException;
import com.depromeet.dodo.user.domain.User;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SessionLoginService implements LoginService {

	private final HttpSession httpSession;

	@Override
	public void login(User user) {

		// TODO : 리팩토링 하기
		httpSession.setAttribute("userId", user.getId());
	}

	@Override
	public long getCurrentUserId() {

		// TODO : 리팩토링 하기
		String loginUserId = (String)httpSession.getAttribute("userId");

		if (loginUserId == null) {
			throw new AccessDeniedException("현재 로그인이 되어있지 않습니다.");
		}

		try {
			return Long.parseLong(loginUserId);
		} catch (NumberFormatException nfe) {
			throw new IllegalStateException("세션에 잘못된 값이 들어가있습니다 : " + loginUserId);
		}
	}
}
