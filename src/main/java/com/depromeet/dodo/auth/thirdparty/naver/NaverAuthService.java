package com.depromeet.dodo.auth.thirdparty.naver;


import com.depromeet.dodo.auth.thirdparty.ThirdPartyAuthService;
import com.depromeet.dodo.auth.thirdparty.naver.api.NaverAuthApiService;
import com.depromeet.dodo.auth.thirdparty.naver.dto.NaverUserProfile;
import com.depromeet.dodo.auth.thirdparty.naver.request.NaverSignInRequest;
import com.depromeet.dodo.auth.thirdparty.naver.request.NaverSignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NaverAuthService implements ThirdPartyAuthService<NaverSignUpRequest, NaverSignInRequest> {

    private final NaverAuthApiService naverAuthApiService;

    @Override
    public void signUp(NaverSignUpRequest request) {

        NaverUserProfile naverProfile = naverAuthApiService.getNaverProfile(request.getToken());

        // TODO : 회원가입 처리 - 추가 설계는 숙제
    }

    @Override
    public void signIn(NaverSignInRequest request) {

        NaverUserProfile naverProfile = naverAuthApiService.getNaverProfile(request.getToken());

        // TODO : 로그인 처리 - 추가 설계는 숙제
    }
}
