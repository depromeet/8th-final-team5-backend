package com.depromeet.dodo.auth.thirdparty.google.payload;

import com.depromeet.dodo.auth.thirdparty.google.dto.GoogleUserProfile;
import com.depromeet.dodo.auth.thirdparty.naver.dto.NaverUserProfile;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class GoogleProfileResponse {

    private GoogleUserProfile googleProfile;

    @JsonCreator
    public GoogleProfileResponse(
            @JsonProperty("response") GoogleUserProfile googleProfile) {
        this.googleProfile = googleProfile;
    }
}
