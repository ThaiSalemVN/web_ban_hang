package com.thai.vn.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * The class handler 500 exception 
 */
@Data
@AllArgsConstructor
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerErrorExc extends RuntimeException {

	private static final long serialVersionUID = -3386580354715006463L;

	private String message;

}