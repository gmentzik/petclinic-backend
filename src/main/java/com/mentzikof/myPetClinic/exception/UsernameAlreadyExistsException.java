package com.mentzikof.myPetClinic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
 
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsernameAlreadyExistsException extends RuntimeException 
{

	private static final long serialVersionUID = -8863581759702119097L;

	public UsernameAlreadyExistsException(String exception) {
        super(exception);
    }
}