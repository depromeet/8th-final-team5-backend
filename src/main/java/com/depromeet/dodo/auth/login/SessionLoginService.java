package com.depromeet.dodo.auth.login;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.depromeet.dodo.user.domain.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SessionLoginService implements LoginService {

	private static final String SESSION_LOGIN_KEY = "UID";

	private final HttpSession httpSession;

	@Override
	public void login(User user) {
		httpSession.setAttribute(SESSION_LOGIN_KEY, user.getId());
	}

}
