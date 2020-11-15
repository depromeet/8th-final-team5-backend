package com.depromeet.dodo.pet.repository;

import com.depromeet.dodo.pet.domain.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
}
