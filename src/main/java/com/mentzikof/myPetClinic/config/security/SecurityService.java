package com.mentzikof.myPetClinic.config.security;


import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;



@Service
public class SecurityService {
	public boolean hasRole(Object principal, String role) {
		List<GrantedAuthority >authorities = (List<GrantedAuthority>) ((PetClinicUserDetails)principal).getAuthorities();
		System.out.println("Principal name: " + ((PetClinicUserDetails)principal).getUsername() + " ,authorities: " + ((PetClinicUserDetails)principal).getAuthorities() );
		System.out.println("Check if principal has role " + role);
		boolean authorized = authorities.contains(new SimpleGrantedAuthority("ADMIN"));
		System.out.println("Found role: " + authorized);
		return authorized;
	}
}
