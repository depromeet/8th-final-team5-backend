package com.depromeet.dodo.auth.login;

import com.depromeet.dodo.user.User;

public interface LoginService {

    void login(User user);

    long getCurrentUserId();
}
