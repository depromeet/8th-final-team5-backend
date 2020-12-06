package com.depromeet.dodo.pet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.depromeet.dodo.pet.domain.PetCharacter;

@Repository
public interface PetCharacterRepository extends JpaRepository<PetCharacter, Long> {
}
