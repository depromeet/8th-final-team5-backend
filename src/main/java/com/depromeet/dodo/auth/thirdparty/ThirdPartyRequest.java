package com.depromeet.dodo.auth.thirdparty;

public interface ThirdPartyRequest {

    String getPrincipal();
    String getCredential();
}
