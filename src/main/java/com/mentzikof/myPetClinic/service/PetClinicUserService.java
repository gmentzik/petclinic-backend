package com.mentzikof.myPetClinic.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mentzikof.myPetClinic.annotation.LogMethodException;
import com.mentzikof.myPetClinic.exception.ConfirmPasswordNotMatchException;
import com.mentzikof.myPetClinic.exception.UsernameAlreadyExistsException;
import com.mentzikof.myPetClinic.model.PetClinicUser;
import com.mentzikof.myPetClinic.model.Role;
import com.mentzikof.myPetClinic.repositories.PetClinicUserRepository;
import com.mentzikof.myPetClinic.repositories.RoleRepository;



@Service
@Transactional
public class PetClinicUserService {
	
    @Autowired
    private PetClinicUserRepository repo;
    
    @Autowired
    private RoleRepository userRoleRepo;
    
    
	@Autowired
	private PasswordEncoder passwordEncoder;
       
	@LogMethodException   
    public PetClinicUser save(PetClinicUser newUser) {

		    String role = newUser.getNewUserRole();
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
                       
            // enable user
            newUser.setEnabled(true);
            
            // Set user role to new user or requested role 
            String findRole = StringUtils.isEmpty(role) ? "USER" : role;
            Role userRole = userRoleRepo.findByName(findRole);
        	Set<Role> roleSet = new HashSet<Role>();
            if (userRole != null) {
            	roleSet.add(userRole);
            	newUser.setRoles(roleSet);	
            }            

            return repo.save(newUser);
    }

	@LogMethodException  
	public List<PetClinicUser> listAllUsers() {
		return (List<PetClinicUser>) repo.findAll();
	}
}