package com.mentzikof.myPetClinic.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mentzikof.myPetClinic.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}

