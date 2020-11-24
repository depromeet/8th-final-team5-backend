package com.depromeet.dodo.image.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.depromeet.dodo.pet.domain.Pet;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "PetProfile")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PetProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	@JoinColumn(name = "imageId")
	private Image image;

	@OneToOne
	@JoinColumn(name = "petId")
	private Pet pet;

	public PetProfile(Image image, Pet pet) {
		this.image = image;
		this.pet = pet;
	}

}
