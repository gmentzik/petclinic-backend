package com.mentzikof.myPetClinic.service;
import java.util.List;

import javax.transaction.Transactional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentzikof.myPetClinic.model.Pet;
import com.mentzikof.myPetClinic.repositories.PetRepository;


@Service
@Transactional
public class PetService {
	
    @Autowired
    private PetRepository repo;
    
    
    public List<Pet> listAll() {
        return repo.findAll();
    }
     
    public void save(Pet pet) {
        repo.save(pet);
    }
     
    public Pet get(Integer id) {
        return repo.findById(id).get();
    }
     
    public void delete(Integer id) {
        repo.deleteById(id);
    }
    
}