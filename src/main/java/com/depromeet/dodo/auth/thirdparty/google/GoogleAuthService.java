package com.depromeet.dodo.auth.thirdparty.google;

import com.depromeet.dodo.auth.thirdparty.ThirdPartyAuthService;
import com.depromeet.dodo.auth.thirdparty.google.api.GoogleAuthApiService;
import com.depromeet.dodo.auth.thirdparty.google.dto.GoogleUserProfile;
import com.depromeet.dodo.auth.thirdparty.google.payload.GoogleSignInRequest;
import com.depromeet.dodo.auth.thirdparty.google.payload.GoogleSignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GoogleAuthService implements ThirdPartyAuthService<GoogleSignUpRequest, GoogleSignInRequest> {

    private final GoogleAuthApiService googleAuthApiService;

    @Override
    public void signUp(GoogleSignUpRequest request) {

        GoogleUserProfile googleProfile = googleAuthApiService.getGoogleProfile(request.getToken());

    }

    @Override
    public void signIn(GoogleSignInRequest request) {

        GoogleUserProfile googleProfile = googleAuthApiService.getGoogleProfile(request.getToken());

    }
}
