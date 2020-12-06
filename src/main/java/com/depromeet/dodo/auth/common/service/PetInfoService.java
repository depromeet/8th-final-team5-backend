package com.depromeet.dodo.auth.common.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.depromeet.dodo.auth.common.dto.SignUpRequest;
import com.depromeet.dodo.pet.domain.Pet;
import com.depromeet.dodo.pet.domain.PetBreed;
import com.depromeet.dodo.pet.domain.PetCharacter;
import com.depromeet.dodo.pet.domain.PetInterest;
import com.depromeet.dodo.pet.service.PetBreedService;
import com.depromeet.dodo.pet.service.PetCharacterService;
import com.depromeet.dodo.pet.service.PetInterestService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PetInfoService {

	private final PetBreedService petBreedService;
	private final PetInterestService petInterestService;
	private final PetCharacterService petCharacterService;

	@Transactional
	public void addPetInfo(Pet pet, SignUpRequest.PetInfo petInfo) {
		List<PetInterest> petInterests = petInfo.getInterests()
			.stream()
			.map(x -> new PetInterest(pet, x))
			.collect(Collectors.toList());
		List<PetCharacter> petCharacters = petInfo.getCharacters()
			.stream()
			.map(x -> new PetCharacter(pet, x))
			.collect(Collectors.toList());

		petBreedService.addPetBreed(new PetBreed(pet, petInfo.getBreed()));
		petInterestService.addAllPetInterest(petInterests);
		petCharacterService.addAllPetCharacter(petCharacters);
	}

}
