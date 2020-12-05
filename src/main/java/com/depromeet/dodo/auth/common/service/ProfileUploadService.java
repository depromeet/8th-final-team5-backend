package com.depromeet.dodo.auth.common.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.depromeet.dodo.common.dto.ImageWithPriority;
import com.depromeet.dodo.common.dto.ProfileImage;
import com.depromeet.dodo.common.service.FileUploadService;
import com.depromeet.dodo.image.domain.Image;
import com.depromeet.dodo.image.domain.PetProfile;
import com.depromeet.dodo.image.service.PetProfileService;
import com.depromeet.dodo.image.service.UserProfileService;
import com.depromeet.dodo.pet.domain.Pet;
import com.depromeet.dodo.user.domain.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfileUploadService {

	private final FileUploadService fileUploadService;
	private final PetProfileService petProfileService;
	private final UserProfileService userProfileService;

	public void addPetProfile(Pet pet, List<ProfileImage> profileImages) {
		List<PetProfile> petProfiles = new ArrayList<>();
		List<ImageWithPriority> profileWithPriority = fileUploadService.multiFileUpload(profileImages);

		profileWithPriority.stream()
			.forEach(x -> petProfiles.add(new PetProfile(x.getImage(), pet, x.getPriority())));

		petProfileService.addProfiles(petProfiles);
	}

	public void addUserProfile(User user, MultipartFile profileImage) {
		Image userProfile = fileUploadService.singleFileUpload(profileImage);
		userProfileService.addImage(user, userProfile);
	}

}
