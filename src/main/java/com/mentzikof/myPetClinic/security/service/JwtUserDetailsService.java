package com.mentzikof.myPetClinic.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.mentzikof.myPetClinic.model.PetClinicUser;
import com.mentzikof.myPetClinic.repositories.PetClinicUserRepository;
import com.mentzikof.myPetClinic.security.model.PetClinicUserDetails;

/*
BCRYPT util web pages
https://www.javainuse.com/onlineBcrypt
https://bcrypt-generator.com/
	
User credentials: admin/password*/


@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private PetClinicUserRepository repo;
    
	@Override
	public PetClinicUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		PetClinicUser user = repo.findByUsername(username);
		if (user != null) {
			return new PetClinicUserDetails(user);		
		} else {
			throw new UsernameNotFoundException("User with username: " + username + " not found!");
		}
	}

}