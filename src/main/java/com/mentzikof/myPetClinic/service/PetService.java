package com.mentzikof.myPetClinic.service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentzikof.myPetClinic.model.Pet;
import com.mentzikof.myPetClinic.model.PetHistory;
import com.mentzikof.myPetClinic.model.dto.PetHistoryDTO;
import com.mentzikof.myPetClinic.model.dto.PetHistoryCreationDateComparator;
import com.mentzikof.myPetClinic.repositories.PetRepository;


@Service
@Transactional
public class PetService {
	
    @Autowired
    private PetRepository repo;
    
    @Autowired
    private CustomerService customerService;

    
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
    
    public PetHistoryDTO getWithHistory(Integer id) throws Exception {
        Pet pet = repo.findById(id).get();
        PetHistoryDTO petHistoryDto = new PetHistoryDTO();
        petHistoryDto.setCustomerFullName(pet.getCustomer().getName() + " " + pet.getCustomer().getSurname());
        petHistoryDto.setPetName(pet.getName());
        petHistoryDto.setSpecies(pet.getSpecies());
        petHistoryDto.setGender(pet.getGender());
        ArrayList<PetHistory> historyList = new ArrayList<>();
        historyList.addAll(pet.getHistory());
        Collections.sort(historyList, new PetHistoryCreationDateComparator());
        petHistoryDto.setPetHistory(historyList);
        return petHistoryDto;
    }
    
}