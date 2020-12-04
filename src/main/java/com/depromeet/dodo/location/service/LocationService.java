package com.depromeet.dodo.location.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.depromeet.dodo.location.domain.Location;
import com.depromeet.dodo.location.repository.LocationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LocationService {

	private final LocationRepository locationRepository;

	@Transactional
	public void addLocation(Location location) {
		locationRepository.save(location);
	}
}
