package com.depromeet.dodo.common.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseEntityConstants {

	private ResponseEntityConstants() {
	}

	public static final ResponseEntity<Void> CREATED = ResponseEntity.status(HttpStatus.CREATED).build();
	public static final ResponseEntity<Void> OK = ResponseEntity.status(HttpStatus.OK).build();
}
