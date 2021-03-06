package com.depromeet.dodo.image.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.depromeet.dodo.image.domain.PetProfile;

@Repository
public interface PetProfileRepository extends JpaRepository<PetProfile, Long> {
}
