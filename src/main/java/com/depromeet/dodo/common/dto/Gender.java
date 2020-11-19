package com.depromeet.dodo.common.dto;

public enum Gender {

	MALE("MALE"), FEMALE("FEMALE");

	private String gender;

	Gender(String gender) {
		this.gender = gender;
	}

	public String getGender() {
		return gender;
	}

	public static Gender of(String genderString) {
		switch (genderString) {
			case "F":
			case "female":
				return FEMALE;
			case "M":
			case "male":
				return MALE;
			default:
				throw new IllegalArgumentException("잘못된 성별 코드가 입력되었습니다 : " + genderString);
		}
	}
}
