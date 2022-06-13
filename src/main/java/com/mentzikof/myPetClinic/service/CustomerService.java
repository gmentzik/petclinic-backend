package com.mentzikof.myPetClinic.service;
import java.util.List;

import javax.transaction.Transactional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mentzikof.myPetClinic.model.Customer;
import com.mentzikof.myPetClinic.model.Customer_;
import com.mentzikof.myPetClinic.repositories.CustomerRepository;
import com.mentzikof.myPetClinic.repositories.specs.CustomerSpecs;
import com.mentzikof.myPetClinic.repositories.specs.SearchCriteria;
import com.mentzikof.myPetClinic.repositories.specs.SearchOperation;


@Service
@Transactional
public class CustomerService {
	
    @Autowired
    private CustomerRepository repo;

    
    public Page<Customer> listAll(int page, int size) {
    	Page<Customer> pageCustomers;
    	Pageable paging = PageRequest.of(page, size);
    	// Test   	    	
//    	pageCustomers = repo.findAll(CustomerSpecs.getCustomerByCriteria(null),paging);
    	CustomerSpecs customerSpecs = new CustomerSpecs();
    	customerSpecs.add(new SearchCriteria(Customer_.NAME, "ΓΙΩ", SearchOperation.MATCH));
    	customerSpecs.add(new SearchCriteria(Customer_.SURNAME, "ΜΕ", SearchOperation.MATCH));
    	customerSpecs.printCriteria();
    	pageCustomers = repo.findAll(customerSpecs,paging);
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