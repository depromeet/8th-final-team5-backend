package com.depromeet.dodo.image.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.depromeet.dodo.image.domain.Image;
import com.depromeet.dodo.image.domain.UserProfile;
import com.depromeet.dodo.image.repository.UserProfileRepository;
import com.depromeet.dodo.user.domain.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserProfileService {

	private final UserProfileRepository userProfileRepository;

	@Transactional
	public void addImage(User user, Image image) {
		userProfileRepository.save(new UserProfile(image, user));
	}

}
