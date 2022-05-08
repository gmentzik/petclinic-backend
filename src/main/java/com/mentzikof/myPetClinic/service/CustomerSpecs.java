package com.mentzikof.myPetClinic.service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import com.mentzikof.myPetClinic.model.Customer;
import com.mentzikof.myPetClinic.model.Customer_;

public class CustomerSpecs {
	
	
    public static Specification<Customer> getCustomerByNameSpec(String name) {
//        return (root, query, criteriaBuilder) -> {
//            return criteriaBuilder.equal(root.get(Customer_.name), name);
//        };
    	return new Specification<Customer>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Customer> customer, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
//                Predicate equalPredicate = criteriaBuilder.equal(customer.get(Customer_.name), name);
//                return equalPredicate;
				if (StringUtils.isEmpty(name)) return null;
                return criteriaBuilder.like(customer.get(Customer_.name), "%"+name+"%");
			}
        };       
        
    }
    
}
