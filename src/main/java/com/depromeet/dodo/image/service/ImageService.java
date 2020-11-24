package com.depromeet.dodo.image.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.depromeet.dodo.image.domain.Image;
import com.depromeet.dodo.image.repository.ImageRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImageService {

	private final ImageRepository imageRepository;

	@Transactional
	public void addImage(Image image) {
		imageRepository.save(image);
	}

}
