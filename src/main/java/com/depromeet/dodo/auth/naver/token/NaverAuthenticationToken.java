package com.depromeet.dodo.auth.naver.token;

import lombok.Getter;
import org.springframework.security.authentication.AbstractAuthenticationToken;

@Getter
public class NaverAuthenticationToken extends AbstractAuthenticationToken {

    private final String naverId;
    private final String accessToken;

    public NaverAuthenticationToken(String naverId, String accessToken) {
        super(null);
        this.naverId = naverId;
        this.accessToken = accessToken;
        setAuthenticated(false);
    }

    @Override
    public Object getCredentials() {
        return accessToken;
    }

    @Override
    public Object getPrincipal() {
        return naverId;
    }
}
