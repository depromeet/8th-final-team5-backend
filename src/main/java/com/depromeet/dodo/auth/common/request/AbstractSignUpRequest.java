package com.depromeet.dodo.auth.common.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class AbstractSignUpRequest {
    // TODO : 회원가입시 받을 정보들

    public abstract String getId();

    public abstract String getCredentials();
}
