package com.depromeet.dodo.auth.thirdparty;

public interface ThirdPartyAuthService<SIGNUP extends ThirdPartyRequest, SIGNIN extends ThirdPartyRequest> {

    void signUp(SIGNUP request);

    void signIn(SIGNIN request);
}
