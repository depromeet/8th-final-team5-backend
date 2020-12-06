package com.depromeet.dodo.pet.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.depromeet.dodo.petInfo.domain.Interest;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "PetInterest")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PetInterest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@OneToOne
	@JoinColumn(name = "petId")
	private Pet pet;

	@OneToOne
	@JoinColumn(name = "interestId")
	private Interest interest;

	public PetInterest(Pet pet, Interest interest) {
		this.pet = pet;
		this.interest = interest;
	}

}
