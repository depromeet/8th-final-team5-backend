package com.depromeet.dodo.pet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.depromeet.dodo.pet.domain.PetInterest;

@Repository
public interface PetInterestRepository extends JpaRepository<PetInterest, Long> {
}
