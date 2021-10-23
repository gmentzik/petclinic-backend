package com.mentzikof.myPetClinic.service;

import javax.transaction.Transactional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mentzikof.myPetClinic.annotation.LogMethodException;
import com.mentzikof.myPetClinic.exception.ConfirmPasswordNotMatchException;
import com.mentzikof.myPetClinic.exception.UsernameAlreadyExistsException;
import com.mentzikof.myPetClinic.model.PetClinicUser;
import com.mentzikof.myPetClinic.repositories.PetClinicUserRepository;



@Service
@Transactional
public class PetClinicUserService {
	
    @Autowired
    private PetClinicUserRepository repo;
    
	@Autowired
	private PasswordEncoder passwordEncoder;
       
	@LogMethodException   
    public PetClinicUser save(PetClinicUser newUser) {

        	newUser.setUsername(newUser.getUsername().trim());
        	if (repo.findByUsername(newUser.getUsername()) != null) 
        		throw new UsernameAlreadyExistsException("User '"+ newUser.getUsername() +"' already exists");

        	newUser.setPassword(newUser.getPassword().trim());
        	
            // Make sure that password and confirmPassword match
        	if (newUser.getConfirmPassword() == null || !newUser.getPassword().equals(newUser.getConfirmPassword().trim())) 
        		throw new ConfirmPasswordNotMatchException("Confirmation Password does not match your password");

            newUser.setPassword(
            		passwordEncoder.encode(newUser.getPassword())
            );
            

            
            // We don't persist or show the confirmPassword
            newUser.setConfirmPassword(null);

            return repo.save(newUser);
    }
}