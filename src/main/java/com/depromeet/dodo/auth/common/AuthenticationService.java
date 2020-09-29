package com.depromeet.dodo.auth.common;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;

    public void authentication(AbstractAuthenticationToken token) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Object prevAuthDetail = securityContext.getAuthentication().getDetails();
        token.setDetails(prevAuthDetail);

        Authentication auth = authenticationManager.authenticate(token);
        securityContext.setAuthentication(auth);
    }
}
