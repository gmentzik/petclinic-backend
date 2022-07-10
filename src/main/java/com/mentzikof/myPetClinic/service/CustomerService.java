package com.mentzikof.myPetClinic.service;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mentzikof.myPetClinic.model.Customer;
import com.mentzikof.myPetClinic.model.Customer_;
import com.mentzikof.myPetClinic.repositories.CustomerRepository;
import com.mentzikof.myPetClinic.repositories.specs.GenericSpecs;
import com.mentzikof.myPetClinic.repositories.specs.SearchCriteria;
import com.mentzikof.myPetClinic.repositories.specs.SearchOperation;


@Service
@Transactional
public class CustomerService {
	
    @Autowired
    private CustomerRepository repo;

    
    public Page<Customer> listAll(int page, int size,String name, String surname, String phone, String mobile) {
    	Page<Customer> pageCustomers;
    	Pageable paging = PageRequest.of(page, size);
    	// Test   	    	
//    	pageCustomers = repo.findAll(CustomerSpecs.getCustomerByCriteria(null),paging);
    	GenericSpecs<Customer> genericSpecs = new GenericSpecs<Customer>();
    	if (!StringUtils.isEmpty(name)) genericSpecs.add(new SearchCriteria(Customer_.NAME, name, SearchOperation.MATCH));
    	if (!StringUtils.isEmpty(surname)) genericSpecs.add(new SearchCriteria(Customer_.SURNAME, surname, SearchOperation.MATCH));
    	if (!StringUtils.isEmpty(phone)) genericSpecs.add(new SearchCriteria(Customer_.PHONE, phone, SearchOperation.MATCH));
    	if (!StringUtils.isEmpty(mobile)) genericSpecs.add(new SearchCriteria(Customer_.MOBILEPHONE, mobile, SearchOperation.MATCH));
    	genericSpecs.printCriteria();
    	pageCustomers = repo.findAll(genericSpecs,paging);
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