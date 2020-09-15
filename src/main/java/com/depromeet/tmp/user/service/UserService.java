package com.depromeet.tmp.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.depromeet.tmp.user.domain.User;
import com.depromeet.tmp.user.dto.UserSignUpRequest;
import com.depromeet.tmp.user.repository.UserRepository;

@Service
@Transactional
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User findByEmail(String email){
		return userRepository.findByEmail(email);
	}

	public User signUp(UserSignUpRequest userSignUpRequest) {
		return userRepository.save(userSignUpRequest.toEntityWithPasswordEncoder());
	}

}
