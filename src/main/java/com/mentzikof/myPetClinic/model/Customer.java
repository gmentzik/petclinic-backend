package com.mentzikof.myPetClinic.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "customer")
@Getter @Setter
public class Customer {
	// Table description
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@NotBlank(message = "Name is mandatory")
	@Size(min = 1, max = 150, message = "Name must be between 1 and 150 characters")
	String name;
	@NotBlank(message = "Surname is mandatory")
	@Size(min = 1, max = 150, message = "Surname Me must be between 1 and 150 characters")
	String surname;
	@Email(message = "Email should be valid")
	String email;
	@Pattern(regexp = "^\\d{10,15}$", message = "Phone must be 10 to 15 digits") // 2111234567
	String phone;
	@Pattern(regexp = "^\\d{10,15}$", message = "Mobile phone must be 10 to 15 digits") // 6974777777
	String mobilephone;
	@Column(updatable=false)
	Date created;
	Date updated;
	
	// Relations
    @OneToMany(
            mappedBy = "customer",
            cascade = CascadeType.REMOVE,
            orphanRemoval = true,
            fetch = FetchType.EAGER
        )
    private List<Pet> pets = new ArrayList<>();

	// OnCreate, OnUpdate
	@PrePersist
	public void onCreate() {
		this.created = new Date();
	}
	
	@PreUpdate
	public void onUpdate() {
		this.updated = new Date();
	}

	
}
