package com.depromeet.dodo.user;

public enum Gender {

	MALE, FEMALE;

	public static Gender of(String genderString) {
		switch(genderString) {
			case "F":
				return FEMALE;
			case "M":
				return MALE;
			default:
				throw new IllegalArgumentException("잘못된 성별 코드가 입력되었습니다 : " + genderString);
		}
	}
}
