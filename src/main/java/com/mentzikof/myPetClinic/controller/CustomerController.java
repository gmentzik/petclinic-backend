package com.mentzikof.myPetClinic.controller;

import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import com.mentzikof.myPetClinic.exception.RecordNotFoundException;
import com.mentzikof.myPetClinic.model.Customer;
import com.mentzikof.myPetClinic.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	 @Autowired
	 private CustomerService service;
	 
	 @GetMapping("hello")
	 public String hello() {
	     return "Hello!!!";
	 }
	 
	 @GetMapping("")
	 public List<Customer> list() {
	     return service.listAll();
	 }
	 
	 @GetMapping("/{id}")
	 public ResponseEntity<Customer> get(@PathVariable Integer id) {
	     try {
	    	 Customer customer = service.get(id);
	         return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	     } catch (NoSuchElementException e) {
	         throw new RecordNotFoundException("Customer with id: " + id + " not found");
	     }       
	 }
	 
	 @PostMapping("")
	 public ResponseEntity<?> add(@Valid @RequestBody Customer customer) {
	     try {
	    	 service.save(customer);
	         return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	     } catch (Exception e) {
	         return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	     }
	 }
	 
	 @PutMapping("/{id}")
	 public ResponseEntity<?> update(@Valid @RequestBody Customer customer, @PathVariable Integer id) {
	     try {
	    	 Customer existCustomer = service.get(id);
	         service.save(customer);
	         return new ResponseEntity<Customer>(service.get(id), HttpStatus.OK);
	     } catch (NoSuchElementException e) {
	         throw new RecordNotFoundException("Customer with id: " + id + " not found");
	     }      
	 }
	 
	 @DeleteMapping("/{id}")
	 public void delete(@PathVariable Integer id) {
	     service.delete(id);
	 }
	 
}


 

