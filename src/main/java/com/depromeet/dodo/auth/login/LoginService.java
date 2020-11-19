package com.depromeet.dodo.auth.login;

import com.depromeet.dodo.user.domain.User;

public interface LoginService {

	void login(User user);

	long getCurrentUserId();
}
