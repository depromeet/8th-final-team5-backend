package com.depromeet.dodo.pet.service;

import org.springframework.stereotype.Service;

import com.depromeet.dodo.pet.domain.PetBreed;
import com.depromeet.dodo.pet.repository.PetBreedRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PetBreedService {

	private final PetBreedRepository petBreedRepository;

	public void addPetBreed(PetBreed petBreed) {
		petBreedRepository.save(petBreed);
	}
}
