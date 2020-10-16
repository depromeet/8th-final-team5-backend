package com.depromeet.dodo.auth.thirdparty.google.payload;

import com.depromeet.dodo.auth.thirdparty.ThirdPartyRequest;
import lombok.Getter;

@Getter
public class GoogleSignInRequest implements ThirdPartyRequest {

    private String googleId;
    private String token;

    @Override
    public String getPrincipal() {
        return googleId;
    }

    @Override
    public String getCredential() {
        return token;
    }
}
