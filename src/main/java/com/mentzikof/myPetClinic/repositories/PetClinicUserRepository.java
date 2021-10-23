package com.mentzikof.myPetClinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mentzikof.myPetClinic.model.PetClinicUser;

public interface PetClinicUserRepository extends CrudRepository<PetClinicUser, Long> {

	PetClinicUser findByUsername(String username);
}