package com.mentzikof.myPetClinic.service;
import java.util.List;

import javax.transaction.Transactional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mentzikof.myPetClinic.model.Customer;
import com.mentzikof.myPetClinic.repositories.CustomerRepository;


@Service
@Transactional
public class CustomerService {
	
    @Autowired
    private CustomerRepository repo;
    
    public Page<Customer> listAll(int page, int size) {
    	Page<Customer> pageCustomers;
    	Pageable paging = PageRequest.of(page, size);
    	pageCustomers = repo.findAll(paging);    	
        return pageCustomers;
    }
     
    public void save(Customer customer) {
        repo.save(customer);
    }
     
    public Customer get(Integer id) {
        return repo.findById(id).get();
    }
     
    public void delete(Integer id) {
        repo.deleteById(id);
    }
    
}