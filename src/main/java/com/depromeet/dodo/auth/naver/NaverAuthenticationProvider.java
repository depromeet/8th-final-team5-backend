package com.depromeet.dodo.auth.naver;

import com.depromeet.dodo.auth.naver.token.NaverAuthenticationToken;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class NaverAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        NaverAuthenticationToken token = (NaverAuthenticationToken) authentication;

        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return NaverAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
