package com.depromeet.dodo.user.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.depromeet.dodo.user.domain.User;
import com.depromeet.dodo.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	@Transactional
	public void signUp(User user) {

		// TODO : 추가 로직

		userRepository.save(user);
	}
}
