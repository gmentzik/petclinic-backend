package com.mentzikof.myPetClinic.controller;

import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.mentzikof.myPetClinic.exception.RecordNotFoundException;
import com.mentzikof.myPetClinic.model.Customer;
import com.mentzikof.myPetClinic.model.Pet;
import com.mentzikof.myPetClinic.model.PetHistory;
import com.mentzikof.myPetClinic.model.dto.PetHistoryDTO;
import com.mentzikof.myPetClinic.service.PetHistoryService;
import com.mentzikof.myPetClinic.service.PetService;

@RestController
@CrossOrigin
@RequestMapping("")
public class PetHistoryController {

	@Autowired
	private PetHistoryService service;

	@Autowired
	private PetService petService;

	@GetMapping("/history/hello")
	public String hello() {
		return "Hello!!!";
	}

	@GetMapping("/history")
	public List<PetHistory> list() {
		return service.listAll();
	}

	@GetMapping("/history/{id}")
	public ResponseEntity<PetHistory> get(@PathVariable Integer id) {
		try {
			PetHistory history = service.get(id);
			return new ResponseEntity<PetHistory>(history, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<PetHistory>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/pet/{petId}/data")
	public ResponseEntity<?> getPetHistory(@PathVariable Integer petId) {
		try {
			return ResponseEntity.ok().body(petService.getWithHistory(petId));
		} catch (NoSuchElementException e) {
			throw new RecordNotFoundException("Pet with id: " + petId + " not found");
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/pet/{petId}/history")
	public ResponseEntity<?> add(@PathVariable Integer petId, @Valid @RequestBody PetHistory history) {
		try {
			Pet pet = petService.get(petId);
			history.setPet(pet);
			service.save(history);
			return new ResponseEntity<PetHistory>(history, HttpStatus.OK);
			
		} catch (NoSuchElementException e) {
			throw new RecordNotFoundException("Pet with id: " + petId + " not found");
		}
		catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/history/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody PetHistory history, @PathVariable Integer id) {
		try {
			PetHistory existPetHistory = service.get(id);
			service.save(history);
			return new ResponseEntity<PetHistory>(service.get(id), HttpStatus.OK);
		} catch (NoSuchElementException e) {
			throw new RecordNotFoundException("PetHistory with id: " + id + " not found");
		}
	}

	@DeleteMapping("/history/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}

}
