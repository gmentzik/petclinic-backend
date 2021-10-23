package com.mentzikof.myPetClinic.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter @Setter
public class PetClinicUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	String username;
	
	String password;

	
}
