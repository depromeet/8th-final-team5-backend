package com.depromeet.tmp.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.depromeet.tmp.user.domain.User;
import com.depromeet.tmp.user.dto.UserSignUpRequest;
import com.depromeet.tmp.user.repository.UserRepository;
import com.depromeet.tmp.util.EncryptionUtils;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public User signUp(UserSignUpRequest userSignUpRequest) {
		return userRepository.save(new User(userSignUpRequest.getEmail(),
			EncryptionUtils.encryptSHA256(userSignUpRequest.getPassword())));
	}

}
