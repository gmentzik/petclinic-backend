package com.mentzikof.myPetClinic.model;

public enum RolesEnum {
	ADMIN("ADMIN"),
	USER("USER");

	public final String value;
	
	RolesEnum(String value) {
		this.value = value;		
	}	
	
}