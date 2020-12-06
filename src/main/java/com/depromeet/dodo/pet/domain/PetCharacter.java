package com.depromeet.dodo.pet.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.depromeet.dodo.petInfo.domain.Charact;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "PetCharacter")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PetCharacter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@OneToOne
	@JoinColumn(name = "petId")
	private Pet pet;

	@OneToOne
	@JoinColumn(name = "characterId")
	private Charact character;

	public PetCharacter(Pet pet, Charact character) {
		this.pet = pet;
		this.character = character;
	}

}
