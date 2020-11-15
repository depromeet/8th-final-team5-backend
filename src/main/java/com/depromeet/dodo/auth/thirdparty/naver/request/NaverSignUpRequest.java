package com.depromeet.dodo.auth.thirdparty.naver.request;

import com.depromeet.dodo.auth.common.SignUpRequest;
import com.depromeet.dodo.auth.thirdparty.ThirdPartyRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class NaverSignUpRequest extends SignUpRequest {

    private String token;

    public NaverSignUpRequest(String username, int age, String address, String introduce, PetInfo petInfo, String token) {
        super(username, age, address, introduce, petInfo);
        this.token = token;
    }
}
