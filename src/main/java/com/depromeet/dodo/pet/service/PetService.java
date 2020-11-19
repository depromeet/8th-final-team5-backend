package com.depromeet.dodo.pet.service;

import com.depromeet.dodo.pet.domain.Pet;
import com.depromeet.dodo.pet.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PetService {

	private final PetRepository petRepository;

	public void addPet(Pet pet) {
		petRepository.save(pet);
	}
}
