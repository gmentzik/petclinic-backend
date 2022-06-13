package com.mentzikof.myPetClinic.repositories.specs;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import com.mentzikof.myPetClinic.model.Customer;
import com.mentzikof.myPetClinic.model.Customer_;

public class CustomerSpecs implements Specification<Customer> {
	private static final long serialVersionUID = 1L;
	private List<SearchCriteria> list;

	public CustomerSpecs() {
		this.list = new ArrayList<>();
	}

	public void add(SearchCriteria criteria) {
		list.add(criteria);
	}
	
	public void printCriteria() {
		for (SearchCriteria c : list) {
			System.out.println(c);
		}
	}
	
	@Override
	public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {


//				if (!StringUtils.isEmpty(name)) {
//					predicates.add(criteriaBuilder.like(root.get(Customer_.name), "%" + name + "%"));
//				}
		
		System.out.println("toPredicate");
		printCriteria();
		
		List<Predicate> predicates = new ArrayList<>();

		// add add criteria to predicates
		for (SearchCriteria criteria : list) {
			if (criteria.getOperation().equals(SearchOperation.GREATER_THAN)) {
				predicates
						.add(criteriaBuilder.greaterThan(root.get(criteria.getKey()), criteria.getValue().toString()));
			} else if (criteria.getOperation().equals(SearchOperation.LESS_THAN)) {
				predicates.add(criteriaBuilder.lessThan(root.get(criteria.getKey()), criteria.getValue().toString()));
			} else if (criteria.getOperation().equals(SearchOperation.GREATER_THAN_EQUAL)) {
				predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get(criteria.getKey()),
						criteria.getValue().toString()));
			} else if (criteria.getOperation().equals(SearchOperation.LESS_THAN_EQUAL)) {
				predicates.add(
						criteriaBuilder.lessThanOrEqualTo(root.get(criteria.getKey()), criteria.getValue().toString()));
			} else if (criteria.getOperation().equals(SearchOperation.NOT_EQUAL)) {
				predicates.add(criteriaBuilder.notEqual(root.get(criteria.getKey()), criteria.getValue()));
			} else if (criteria.getOperation().equals(SearchOperation.EQUAL)) {
				predicates.add(criteriaBuilder.equal(root.get(criteria.getKey()), criteria.getValue()));
			} else if (criteria.getOperation().equals(SearchOperation.MATCH)) {
//				predicates.add(criteriaBuilder.like(root.get(Customer_.name), "%" + name + "%"));	
// Needs work. 
// Cannot understand 	criteriaBuilder.lower(root.get(criteria.getKey()))
// Can I make Customer_.name work in Service to avoid having error with column names?
// Can I make CustomerSpecs a generic class?
				
				
				System.out.println("SearchOperation.MATCH");		
				System.out.println(criteria.getKey());
				System.out.println(criteriaBuilder.lower(root.get(criteria.getKey())));
				System.out.println("%" + criteria.getValue().toString() + "%");
                predicates.add(criteriaBuilder.like(
                		criteriaBuilder.lower(root.get(criteria.getKey())),
                        "%" + criteria.getValue().toString().toUpperCase() + "%"));
			} else if (criteria.getOperation().equals(SearchOperation.MATCH_END)) {
				predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get(criteria.getKey())),
						criteria.getValue().toString().toLowerCase() + "%"));
			} else if (criteria.getOperation().equals(SearchOperation.MATCH_START)) {
				predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get(criteria.getKey())),
						"%" + criteria.getValue().toString().toLowerCase()));
			} else if (criteria.getOperation().equals(SearchOperation.IN)) {
				predicates.add(criteriaBuilder.in(root.get(criteria.getKey())).value(criteria.getValue()));
			} else if (criteria.getOperation().equals(SearchOperation.NOT_IN)) {
				predicates.add(criteriaBuilder.not(root.get(criteria.getKey())).in(criteria.getValue()));
			}

		}
		
		return criteriaBuilder.and(predicates.toArray(Predicate[]::new));
	};

}
