package com.thai.vn.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * The class handler 400 exception 
 */
@Data
@AllArgsConstructor
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestExc extends RuntimeException{

	private static final long serialVersionUID = 2012912794336239642L;
	
	private String message;
	
	
}
