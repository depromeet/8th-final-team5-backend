package com.depromeet.dodo.pet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.depromeet.dodo.pet.domain.PetInterest;
import com.depromeet.dodo.pet.repository.PetInterestRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PetInterestService {

	private final PetInterestRepository petInterestRepository;

	public void addAllPetInterest(List<PetInterest> petInterest) {
		petInterestRepository.saveAll(petInterest);
	}

}
