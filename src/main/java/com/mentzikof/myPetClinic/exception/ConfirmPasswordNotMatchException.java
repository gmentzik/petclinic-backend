package com.mentzikof.myPetClinic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
 
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ConfirmPasswordNotMatchException extends RuntimeException 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 203414248891911305L;

	public ConfirmPasswordNotMatchException(String exception) {
        super(exception);
    }
}