package com.depromeet.tmp.common.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.depromeet.tmp.common.exception.DuplicateEmailException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(DuplicateEmailException.class)
	public ResponseEntity duplicateEmailException(Exception e) {
		return ResponseEntity.badRequest().body(e.getMessage());
	}

	@ExceptionHandler(BindException.class)
	public ResponseEntity validationException(BindException e) {
		return ResponseEntity.badRequest().body(e.getFieldError().getDefaultMessage());
	}

}
