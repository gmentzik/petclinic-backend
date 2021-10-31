package com.mentzikof.myPetClinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mentzikof.myPetClinic.model.Role;

public interface RoleRepository extends CrudRepository<Role, Integer>  {
	
	Role findByName(String roleName);

}
