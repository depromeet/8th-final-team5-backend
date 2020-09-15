package com.depromeet.tmp.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.depromeet.tmp.user.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

}

