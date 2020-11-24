package com.depromeet.dodo.image.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.depromeet.dodo.image.domain.Image;
import com.depromeet.dodo.image.domain.PetProfile;
import com.depromeet.dodo.image.repository.PetProfileRepository;
import com.depromeet.dodo.pet.domain.Pet;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PetProfileService {

	private final PetProfileRepository petProfileRepository;

	@Transactional
	public void addImage(Pet pet, Image image) {
		petProfileRepository.save(new PetProfile(image, pet));
	}

}
