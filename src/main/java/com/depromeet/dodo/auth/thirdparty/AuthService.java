package com.depromeet.dodo.auth.thirdparty;

import com.depromeet.dodo.auth.common.SignUpRequest;
import com.depromeet.dodo.auth.common.UserInfo;

public interface AuthService<SIGNUP extends SignUpRequest, SIGNIN extends ThirdPartyRequest> {

    void signUp(SIGNUP request);

    void signIn(SIGNIN request);

    UserInfo getUserInfo(String userId, String token);
}
