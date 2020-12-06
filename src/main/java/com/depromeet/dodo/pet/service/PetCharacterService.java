package com.depromeet.dodo.pet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.depromeet.dodo.pet.domain.PetCharacter;
import com.depromeet.dodo.pet.repository.PetCharacterRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PetCharacterService {

	private final PetCharacterRepository petCharacterRepository;

	public void addAllPetCharacter(List<PetCharacter> petCharacters) {
		petCharacterRepository.saveAll(petCharacters);
	}

}
