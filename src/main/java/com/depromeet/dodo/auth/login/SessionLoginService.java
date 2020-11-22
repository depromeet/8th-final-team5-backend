package com.depromeet.dodo.auth.login;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SessionLoginService implements LoginService {

	private static final String SESSION_LOGIN_KEY = "UID";

	private final HttpSession httpSession;

	@Override
	public void login(String uid) {
		httpSession.setAttribute(SESSION_LOGIN_KEY, uid);
	}

}
