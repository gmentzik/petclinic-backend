package com.mentzikof.myPetClinic.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
public class PetClinicUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@NotBlank(message = "username is required")
	String username;
	@NotBlank(message = "password is required")
	String password;
    @Transient
    private String confirmPassword;
	
}
