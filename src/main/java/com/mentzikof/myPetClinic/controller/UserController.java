package com.mentzikof.myPetClinic.controller;

import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentzikof.myPetClinic.annotation.LogMethodException;
import com.mentzikof.myPetClinic.annotation.LogMethodExecutionTime;
import com.mentzikof.myPetClinic.annotation.LogMethodInputData;
import com.mentzikof.myPetClinic.model.Customer;
import com.mentzikof.myPetClinic.model.PetClinicUser;
import com.mentzikof.myPetClinic.service.PetClinicUserService;

@RestController
@RequestMapping("/user")
public class UserController {

	 @Autowired
	 private PetClinicUserService service;
	 
	 @LogMethodExecutionTime
	 @GetMapping("hello")
	 public String hello() {
	     return "Hello!!!";
	 }

	 @LogMethodInputData
	 @LogMethodExecutionTime
	 @LogMethodException
	 @GetMapping("")
	 public List<PetClinicUser> listAllUsers() {
	    	 return service.listAllUsers();
	 }
	 
	 @LogMethodInputData
	 @LogMethodExecutionTime
	 @LogMethodException
	 @PostMapping("")
	 public ResponseEntity<?> add(@Valid @RequestBody PetClinicUser user) {
	    	 user = service.save(user);
	         return new ResponseEntity<PetClinicUser>(user, HttpStatus.OK);
	 }

}


 

