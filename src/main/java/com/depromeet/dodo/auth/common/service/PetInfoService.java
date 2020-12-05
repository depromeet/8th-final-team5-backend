package com.depromeet.dodo.auth.common.service;

import java.util.ArrayList;
import java.util.List;

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

	public void addPetInfo(Pet pet, SignUpRequest.PetInfo petInfo) {
		List<PetInterest> petInterests = new ArrayList<>();
		List<PetCharacter> petCharacters = new ArrayList<>();

		petInfo.getInterests().stream().forEach(x -> petInterests.add(new PetInterest(pet, x)));
		petInfo.getCharacters().stream().forEach(x -> petCharacters.add(new PetCharacter(pet, x)));

		petBreedService.addPetBreed(new PetBreed(pet, petInfo.getBreed()));
		petInterestService.addAllPetInterest(petInterests);
		petCharacterService.addAllPetCharacter(petCharacters);
	}

}
