package com.mentzikof.myPetClinic.controller;

import java.util.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.http.*;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import com.mentzikof.myPetClinic.annotation.LogMethodException;
import com.mentzikof.myPetClinic.annotation.LogMethodExecutionTime;
import com.mentzikof.myPetClinic.annotation.LogMethodInputData;
import com.mentzikof.myPetClinic.exception.RecordNotFoundException;
import com.mentzikof.myPetClinic.model.Customer;
import com.mentzikof.myPetClinic.service.CustomerService;

@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {

	 @Autowired
	 private CustomerService service;
	 
	 @LogMethodExecutionTime
	 @GetMapping("hello")
	 public String hello() {
	     return "Hello!!!";
	 }
	 
		@LogMethodExecutionTime
		@GetMapping("")
		public ResponseEntity<Map<String, Object>> list(@RequestParam(defaultValue = "0") int page,
				@RequestParam(defaultValue = "3") int size) {

			Page<Customer> pageData = service.listAll(page, size);
			Map<String, Object> response = new HashMap<>();
			response.put("customers", pageData.getContent());
			response.put("currentPage", pageData.getNumber());
			response.put("totalItems", pageData.getTotalElements());
			response.put("totalPages", pageData.getTotalPages());

			return ResponseEntity.ok(response);
		}
	 
	 @LogMethodInputData
	 @LogMethodExecutionTime
	 @GetMapping("/{id}")
	 public ResponseEntity<Customer> get(@PathVariable Integer id) {
	     try {
	    	 Customer customer = service.get(id);
	         return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	     } catch (NoSuchElementException e) {
	         throw new RecordNotFoundException("Customer with id: " + id + " not found");
	     }       
	 }
	 
	 @LogMethodInputData
	 @LogMethodExecutionTime
	 @LogMethodException
	 @PostMapping("")
	 public ResponseEntity<?> add(@Valid @RequestBody Customer customer) {
	     try {
	    	 service.save(customer);
	         return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	     } catch (Exception e) {
	         return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	     }
	 }
	 
	 @LogMethodInputData
	 @LogMethodExecutionTime
	 @LogMethodException
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
	 
	 @LogMethodInputData
	 @LogMethodExecutionTime
	 @LogMethodException
//	 @PreAuthorize("hasRole('ROLE_ADMIN')")
//	 @PreAuthorize("hasAuthority('ADMIN')")
	 @PreAuthorize("@securityService.hasRole(authentication.principal,'ADMIN')")
	 @DeleteMapping("/{id}")
	 public void delete(@PathVariable Integer id) {
	     service.delete(id);
	 }
	 
}


 

