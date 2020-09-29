package com.depromeet.dodo.auth.common;

import com.depromeet.dodo.auth.common.request.AbstractSignUpRequest;
import com.depromeet.dodo.auth.common.request.SignInRequest;

public interface LoginService<U extends AbstractSignUpRequest, I extends SignInRequest> {

    void signUp(U request);

    void signIn(I request);
}
