package com.mentzikof.myPetClinic.controller;

import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.mentzikof.myPetClinic.exception.RecordNotFoundException;
import com.mentzikof.myPetClinic.model.Pet;
import com.mentzikof.myPetClinic.model.PetHistory;
import com.mentzikof.myPetClinic.service.PetHistoryService;
import com.mentzikof.myPetClinic.service.PetService;

@RestController
@RequestMapping("/history")
public class PetHistoryController {

	 @Autowired
	 private PetHistoryService service;
	 
	 @GetMapping("hello")
	 public String hello() {
	     return "Hello!!!";
	 }
	 
	 @GetMapping("")
	 public List<PetHistory> list() {
	     return service.listAll();
	 }
	 
	 @GetMapping("/{id}")
	 public ResponseEntity<PetHistory> get(@PathVariable Integer id) {
	     try {
	    	 PetHistory history = service.get(id);
	         return new ResponseEntity<PetHistory>(history, HttpStatus.OK);
	     } catch (NoSuchElementException e) {
	         return new ResponseEntity<PetHistory>(HttpStatus.NOT_FOUND);
	     }      
	 }
	 
	 @PostMapping("")
	 public ResponseEntity<?> add(@Valid @RequestBody PetHistory history) {
	     try {
	    	 service.save(history);
	         return new ResponseEntity<PetHistory>(history, HttpStatus.OK);
	     } catch (Exception e) {
	         return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	     }
	 }
	 
	 @PutMapping("/{id}")
	 public ResponseEntity<?> update(@Valid @RequestBody PetHistory history, @PathVariable Integer id) {
	     try {
	    	 PetHistory existPetHistory = service.get(id);
	         service.save(history);
	         return new ResponseEntity<PetHistory>(service.get(id), HttpStatus.OK);
	     } catch (NoSuchElementException e) {
	         throw new RecordNotFoundException("Customer with id: " + id + " not found");
	     }      
	 }
	 
	 @DeleteMapping("/{id}")
	 public void delete(@PathVariable Integer id) {
	     service.delete(id);
	 }
	 
}


 

