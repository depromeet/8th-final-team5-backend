package com.depromeet.dodo.auth.thirdparty.naver.request;

import com.depromeet.dodo.auth.thirdparty.ThirdPartyRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class NaverSignInRequest implements ThirdPartyRequest {

    private String naverId;
    private String token;

    // TODO : 로그인시에 받을 정보들 추가하기 (추가 설계는 숙제)

    @Override
    public String getPrincipal() {
        return naverId;
    }

    @Override
    public String getCredential() {
        return token;
    }
}
