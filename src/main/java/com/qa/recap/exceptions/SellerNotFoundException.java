package com.qa.recap.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "No seler found with that id")
public class SellerNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4109663872737177331L;

}
