package com.mentzikof.myPetClinic.security.service;


import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.mentzikof.myPetClinic.security.model.PetClinicUserDetails;



@Service
@SuppressWarnings("unchecked")
public class SecurityService {
	public boolean hasRole(Object principal, String role) {
		String username = ((PetClinicUserDetails)principal).getUsername();
		List<GrantedAuthority> authorities = (List<GrantedAuthority>) ((PetClinicUserDetails)principal).getAuthorities();
		boolean authorized = authorities.contains(new SimpleGrantedAuthority(role));
//		Prints to verify operation. To be removed or just log debug.
		System.out.println("User name: " + username + " ,authorities: " + authorities );
		System.out.println("Check if " + username +  " has role " + role);
		System.out.println("Found role: " + authorized);
		return authorized;
	}
}
