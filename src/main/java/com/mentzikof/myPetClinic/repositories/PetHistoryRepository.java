package com.mentzikof.myPetClinic.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mentzikof.myPetClinic.model.PetHistory;

public interface PetHistoryRepository extends JpaRepository<PetHistory, Integer>{

}

