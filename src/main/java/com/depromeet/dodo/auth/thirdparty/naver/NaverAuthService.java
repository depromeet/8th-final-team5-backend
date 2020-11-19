package com.depromeet.dodo.auth.thirdparty.naver;


import com.depromeet.dodo.auth.common.UserInfo;
import com.depromeet.dodo.auth.thirdparty.AuthService;
import com.depromeet.dodo.auth.thirdparty.naver.api.NaverAuthApiService;
import com.depromeet.dodo.auth.thirdparty.naver.dto.NaverUserProfile;
import com.depromeet.dodo.auth.thirdparty.naver.request.NaverSignInRequest;
import com.depromeet.dodo.auth.thirdparty.naver.request.NaverSignUpRequest;
import com.depromeet.dodo.common.dto.Gender;
import com.depromeet.dodo.pet.domain.Pet;
import com.depromeet.dodo.pet.service.PetService;
import com.depromeet.dodo.user.domain.User;
import com.depromeet.dodo.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class NaverAuthService implements AuthService<NaverSignUpRequest, NaverSignInRequest> {

    private static final String UID_POSTFIX = "@NAVER";

    private final NaverAuthApiService naverAuthApiService;
    private final UserService userService;
    private final PetService petService;

    @Transactional
    @Override
    public void signUp(NaverSignUpRequest request) {

        NaverUserProfile naverProfile = naverAuthApiService.getNaverProfile(request.getToken());

        Pet pet = Pet.builder()
                .age(request.getPetInfo().getAge())
                .breed(request.getPetInfo().getBreed())
                .fixing(request.getPetInfo().isFixing())
                .gender(request.getPetInfo().getGender())
                .name(request.getPetInfo().getName())
                .vaccination(request.getPetInfo().isVaccination())
                .build();

        petService.addPet(pet);

        User newUser = User.builder()
                .uid(generateUserUid(naverProfile.getId()))
                .gender(Gender.of(naverProfile.getGender()))
                .profileImageUrl(naverProfile.getProfileImage())
                .introduce(request.getIntroduce())
                .username(request.getUsername())
                .address(request.getAddress())
                .age(request.getAge())
                .pet(pet)
                .build();

        userService.signUp(newUser);
    }

    @Override
    public void signIn(NaverSignInRequest request) {

        NaverUserProfile naverProfile = naverAuthApiService.getNaverProfile(request.getToken());

        // TODO : 로그인 처리 - 추가 설계는 숙제
    }

    @Override
    public UserInfo getUserInfo(String userId, String token) {
        NaverUserProfile naverProfile = naverAuthApiService.getNaverProfile(token);

        return UserInfo.builder()
                .name(naverProfile.getName())
                .gender(Gender.of(naverProfile.getGender()))
                .profileImageUrl(naverProfile.getProfileImage())
                .build();
    }

    private String generateUserUid(String naverId) {
        return naverId + UID_POSTFIX;
    }
}
