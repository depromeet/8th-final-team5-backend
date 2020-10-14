package com.depromeet.dodo.auth.thirdparty.naver.api;

import com.depromeet.dodo.auth.thirdparty.naver.dto.NaverUserProfile;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * 참고 : https://developers.naver.com/docs/login/profile/
 */
@RequiredArgsConstructor
@Component
public class NaverAuthApiService {

    private static final String NAVER_PROFILE_URL = "https://openapi.naver.com/v1/nid/me";

    private final WebClient apiWebClient;

    public NaverUserProfile getNaverProfile(String token) {

        return apiWebClient.get()
                .uri(NAVER_PROFILE_URL)
                .headers(headers -> headers.setBearerAuth(token))
                .retrieve()
                .bodyToMono(NaverProfileResponse.class)
                .map(response -> {

                    switch (response.resultCode) {
                        case "00":
                            return response.getNaverProfile();
                        case "024":
                        case "028":
                        case "403":
                        case "404":
                            throw new IllegalArgumentException(response.message);
                        default:
                            throw new IllegalStateException(response.message);
                    }
                })
                .block();
    }

    @Getter
    public static class NaverProfileResponse {

        private String resultCode;
        private String message;
        private NaverUserProfile naverProfile;

        @JsonCreator
        public NaverProfileResponse(
                @JsonProperty("resultcode") String resultCode,
                @JsonProperty("message") String message,
                @JsonProperty("response") NaverUserProfile naverProfile) {
            this.resultCode = resultCode;
            this.message = message;
            this.naverProfile = naverProfile;
        }
    }
}
