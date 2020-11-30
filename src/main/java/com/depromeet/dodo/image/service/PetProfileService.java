package com.depromeet.dodo.image.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.depromeet.dodo.image.domain.PetProfile;
import com.depromeet.dodo.image.repository.PetProfileRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PetProfileService {

	private final PetProfileRepository petProfileRepository;

	@Transactional
	public void addProfiles(List<PetProfile> petProfiles) {
		petProfileRepository.saveAll(petProfiles);
	}

}
