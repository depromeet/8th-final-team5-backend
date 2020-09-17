package com.depromeet.tmp.common.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.depromeet.tmp.common.exception.DuplicateEmailException;
import com.depromeet.tmp.common.exception.NotEqualsPasswordException;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(DuplicateEmailException.class)
	public ResponseEntity duplicateEmailException(Exception e) {
		return ResponseEntity.badRequest().body(e.getMessage());
	}

	@ExceptionHandler(NotEqualsPasswordException.class)
	public ResponseEntity NotMatchPasswordException(Exception e) {
		return ResponseEntity.badRequest().body(e.getMessage());
	}

}
