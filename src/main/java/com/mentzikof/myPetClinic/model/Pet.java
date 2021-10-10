package com.mentzikof.myPetClinic.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pet")
@Getter @Setter @NoArgsConstructor
public class Pet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="customer_id")
	Customer customer;
	String name;
	String species;
	String gender;
	@Column(updatable=false)
	Date created;
	Date updated;
	
	// Relations
    @OneToMany(
            mappedBy = "pet",
            cascade = CascadeType.REMOVE,
            orphanRemoval = true,
            fetch = FetchType.EAGER
        )
    private List<PetHistory> history = new ArrayList<>();

	@PrePersist
	public void onCreate() {
		this.created = new Date();
	}
	
	@PreUpdate
	public void onUpdate() {
		this.updated = new Date();
	}
}
