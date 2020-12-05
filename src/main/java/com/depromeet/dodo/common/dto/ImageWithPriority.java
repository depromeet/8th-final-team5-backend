package com.depromeet.dodo.common.dto;

import com.depromeet.dodo.image.domain.Image;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ImageWithPriority {
	private Image image;
	private int priority;
}
