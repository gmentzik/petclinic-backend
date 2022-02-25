package com.mentzikof.myPetClinic.model.dto;

import java.io.Serializable;
import java.util.List;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String username;
	private final String jwttoken;
	private List<String> roles;

	public JwtResponse(String jwttoken, String username, List<String> roles) {
		this.jwttoken = jwttoken;
		this.username = username;
		this.roles = roles;
	}

	public String getToken() {
		return this.jwttoken;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public String getUsername() {
		return username;
	}

	public String getJwttoken() {
		return jwttoken;
	}
}