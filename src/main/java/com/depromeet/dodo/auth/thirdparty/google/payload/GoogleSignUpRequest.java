package com.depromeet.dodo.auth.thirdparty.google.payload;

import com.depromeet.dodo.auth.thirdparty.ThirdPartyRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GoogleSignUpRequest implements ThirdPartyRequest {

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
