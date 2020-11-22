package com.depromeet.dodo.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.depromeet.dodo.user.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUid(String uid);

}
