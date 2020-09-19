package com.depromeet.tmp.common.exception;

public class DuplicateEmailException extends IllegalArgumentException {
	public DuplicateEmailException(String message) {
		super(message);
	}
}
