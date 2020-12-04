package com.depromeet.dodo.user.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.depromeet.dodo.common.dto.Gender;
import com.depromeet.dodo.location.domain.Location;
import com.depromeet.dodo.pet.domain.Pet;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "User")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String uid;

	private String username;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	private int age;

	private String introduce;

	private String profileImageUrl;

	@OneToOne
	@JoinColumn(name = "locationId")
	private Location location;

	@OneToOne
	@JoinColumn(name = "petId")
	private Pet pet;

}
