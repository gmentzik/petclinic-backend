package com.mentzikof.myPetClinic.controller;

import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.mentzikof.myPetClinic.exception.RecordNotFoundException;
import com.mentzikof.myPetClinic.model.Customer;
import com.mentzikof.myPetClinic.model.Pet;
import com.mentzikof.myPetClinic.service.CustomerService;
import com.mentzikof.myPetClinic.service.PetService;

@RestController
@RequestMapping("")
public class PetController {

	@Autowired
	private PetService service;

	@Autowired
	private CustomerService customerService;

	@GetMapping("/pethello")
	public String hello() {
		return "Hello!!!";
	}

	@GetMapping("/pet")
	public List<Pet> list() {
		return service.listAll();
	}

	@GetMapping("/pet/{id}")
	public ResponseEntity<Pet> get(@PathVariable Integer id) {
		try {
			Pet pet = service.get(id);
			return new ResponseEntity<Pet>(pet, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			throw new RecordNotFoundException("Pet with id: " + id + " not found");
		}
	}

	@GetMapping("/customer/{customerId}/pet")
	public List<Pet> getCustomerPets(@PathVariable Integer customerId) {
		try {
			Customer customer = customerService.get(customerId);
			return customer.getPets();

		} catch (NoSuchElementException e) {
			throw new RecordNotFoundException("Customer with id: " + customerId + " not found");
		}
	}

	@PostMapping("/customer/{customerId}/pet")
	public ResponseEntity<?> add(@PathVariable Integer customerId, @Valid @RequestBody Pet pet) {
		try {
			Customer customer = customerService.get(customerId);
			pet.setCustomer(customer);
			service.save(pet);
			return new ResponseEntity<Pet>(pet, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			throw new RecordNotFoundException("Customer with id: " + customerId + " not found");
		}

		catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/pet/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Pet pet, @PathVariable Integer id) {
		try {
			Pet existPet = service.get(id);
			service.save(pet);
			return new ResponseEntity<Pet>(service.get(id), HttpStatus.OK);
		} catch (NoSuchElementException e) {
			throw new RecordNotFoundException("Customer with id: " + id + " not found");
		}
	}

	@DeleteMapping("/pet/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}

}
