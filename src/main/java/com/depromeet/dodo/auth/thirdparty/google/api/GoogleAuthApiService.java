package com.depromeet.dodo.auth.thirdparty.google.api;

import com.depromeet.dodo.auth.thirdparty.google.dto.GoogleUserProfile;
import com.depromeet.dodo.auth.thirdparty.google.payload.GoogleProfileResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@RequiredArgsConstructor
@Service
public class GoogleAuthApiService {

    private static final String GOOGLE_PROFILE_URL = "https://www.googleapis.com/oauth2/v2/userinfo";

    private final WebClient apiWebClient;

    public GoogleUserProfile getGoogleProfile(String token) {

        return apiWebClient.get()
                .uri(GOOGLE_PROFILE_URL)
                .headers(headers -> headers.setBearerAuth(token))
                .retrieve()
                .bodyToMono(GoogleProfileResponse.class)
                .map(response -> {
                    return response.getGoogleProfile();
                })
                .block();
    }

}
