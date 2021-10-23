package com.mentzikof.myPetClinic.config.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.mentzikof.myPetClinic.model.PetClinicUser;
import com.mentzikof.myPetClinic.repositories.PetClinicUserRepository;

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
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		PetClinicUser user = repo.findByUsername(username);
		if (user != null) {
//			return new User("user", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
//			new ArrayList<>());
			return new PetClinicUserDetailsPrincipal(user);		
		} else {
			throw new UsernameNotFoundException("User with username: " + username + " not found!");
		}
	}

}