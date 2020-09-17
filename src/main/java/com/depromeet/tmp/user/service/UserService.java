package com.depromeet.tmp.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.depromeet.tmp.common.exception.DuplicateEmailException;
import com.depromeet.tmp.common.exception.NotEqualsPasswordException;
import com.depromeet.tmp.user.domain.User;
import com.depromeet.tmp.user.dto.UserSignUpRequest;
import com.depromeet.tmp.user.repository.UserRepository;
import com.depromeet.tmp.util.EncryptionUtils;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User signUp(UserSignUpRequest userSignUpRequest) {
		return userRepository.save(new User(userSignUpRequest.getEmail(),
			EncryptionUtils.encryptSHA256(userSignUpRequest.getPassword1())));
	}

	public boolean hasErrors(UserSignUpRequest userSignUpRequest, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return true;
		}

		if(!userSignUpRequest.getPassword1().equals(userSignUpRequest.getPassword2())) {
			throw new NotEqualsPasswordException("두 비밀번호가 일치하지 않습니다.");
		}

		if(userRepository.findByEmail(userSignUpRequest.getEmail()) != null) {
			throw new DuplicateEmailException("이미 사용 중인 이메일입니다.");
		}

		return false;
	}

}
