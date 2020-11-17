package com.depromeet.dodo.pet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.depromeet.dodo.pet.domain.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
}
