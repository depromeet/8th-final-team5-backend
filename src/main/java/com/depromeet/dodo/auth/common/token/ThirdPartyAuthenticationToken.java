package com.depromeet.dodo.auth.common.token;

import com.depromeet.dodo.auth.common.DoDoUserDetails;
import lombok.Getter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Getter
public class ThirdPartyAuthenticationToken extends AbstractAuthenticationToken {

    private final DoDoUserDetails userDetails;
    private final String accessToken;

    public ThirdPartyAuthenticationToken(
            DoDoUserDetails userDetails,
            String accessToken,
            Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.userDetails = userDetails;
        this.accessToken = accessToken;
        setAuthenticated(true);
    }

    @Override
    public Object getPrincipal() {
        return userDetails;
    }

    @Override
    public Object getCredentials() {
        return accessToken;
    }
}
