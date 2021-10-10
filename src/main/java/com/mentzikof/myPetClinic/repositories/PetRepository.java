package com.mentzikof.myPetClinic.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mentzikof.myPetClinic.model.Pet;

public interface PetRepository extends JpaRepository<Pet, Integer>{

}

