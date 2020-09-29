package com.depromeet.dodo.auth.naver.request;

import com.depromeet.dodo.auth.common.request.AbstractSignUpRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class NaverSignUpRequest extends AbstractSignUpRequest {

    private String accessToken;
    private String naverId;

    @Override
    public String getId() {
        return naverId;
    }

    @Override
    public String getCredentials() {
        return accessToken;
    }
}
