package com.depromeet.dodo.auth.thirdparty.kakao.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.depromeet.dodo.auth.common.UserInfo;
import com.depromeet.dodo.auth.login.LoginService;
import com.depromeet.dodo.auth.thirdparty.AuthService;
import com.depromeet.dodo.auth.thirdparty.kakao.api.KakaoAuthApiService;
import com.depromeet.dodo.auth.thirdparty.kakao.request.KakaoSignInRequest;
import com.depromeet.dodo.auth.thirdparty.kakao.request.KakaoSignUpRequest;
import com.depromeet.dodo.auth.thirdparty.kakao.response.KakaoProfileResponse;
import com.depromeet.dodo.common.dto.Gender;
import com.depromeet.dodo.pet.domain.Pet;
import com.depromeet.dodo.pet.service.PetService;
import com.depromeet.dodo.user.domain.User;
import com.depromeet.dodo.user.repository.UserRepository;
import com.depromeet.dodo.user.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class KakaoAuthService implements AuthService<KakaoSignUpRequest, KakaoSignInRequest> {

	private static final String UID_POSTFIX = "@KAKAO";

	private final LoginService loginService;
	private final KakaoAuthApiService kakaoAuthApiService;
	private final UserService userService;
	private final PetService petService;

	private final UserRepository userRepository;

	@Transactional
	@Override
	public void signUp(KakaoSignUpRequest request) {
		KakaoProfileResponse kakaoUserProfile = kakaoAuthApiService.getKaKaoProfile(request.getToken());

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
			.uid(generateUserUid(kakaoUserProfile.getId()))
			.gender(Gender.of(kakaoUserProfile.getKakaoAccount().getGender()))
			.profileImageUrl(kakaoUserProfile.getKakaoAccount().getProfile().getProfileImageUrl())
			.introduce(request.getIntroduce())
			.username(request.getUsername())
			.address(request.getAddress())
			.age(request.getAge())
			.pet(pet)
			.build();

		userService.signUp(newUser);
	}

	@Override
	public void signIn(KakaoSignInRequest request) {
		KakaoProfileResponse kakaoProfile = kakaoAuthApiService.getKaKaoProfile(request.getPrincipal());

		if (kakaoProfile.getId().equals(request.getPrincipal())) {
			userRepository.findByUid(request.getCredential().concat(UID_POSTFIX))
				.orElseThrow(() -> new SecurityException("회원가입이 필요한 사용자입니다."));
			loginService.login(request.getCredential());
		} else {
			throw new IllegalArgumentException("잘못된 UID 입니다. : " + request.getPrincipal());
		}
	}

	@Override
	public UserInfo getUserInfo(String userId, String token) {
		KakaoProfileResponse kakaoProfileResponse = kakaoAuthApiService.getKaKaoProfile(token);

		return UserInfo.builder()
			.name(kakaoProfileResponse.getKakaoAccount().getProfile().getNickName())
			.gender(Gender.of(kakaoProfileResponse.getKakaoAccount().getGender()))
			.profileImageUrl(kakaoProfileResponse.getKakaoAccount().getProfile().getProfileImageUrl())
			.build();
	}

	private String generateUserUid(String kakaoId) {
		return kakaoId + UID_POSTFIX;
	}

}
