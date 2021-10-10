package com.mentzikof.myPetClinic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
 
@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends RuntimeException 
{

	private static final long serialVersionUID = -8863581759702119097L;

	public RecordNotFoundException(String exception) {
        super(exception);
    }
}