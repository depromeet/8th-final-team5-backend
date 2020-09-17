package com.depromeet.tmp.common.exception;

public class DuplicateEmailException extends RuntimeException {
	public DuplicateEmailException(String message) {
		super(message);
	}
}
