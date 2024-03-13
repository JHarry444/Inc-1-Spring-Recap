package com.qa.recap.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Delete failed")
public class DeleteFailedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4673901527792429603L;

}
