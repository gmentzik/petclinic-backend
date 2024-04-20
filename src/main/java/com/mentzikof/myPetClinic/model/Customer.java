package com.mentzikof.myPetClinic.model;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	@Size(min = 1, max = 150, message = "Surname must be between 1 and 150 characters")
	String surname;

	@Size(min = 1, max = 150, message = "Address must be between 1 and 150 characters")
	String address;
	@Size(min = 1, max = 150, message = "Area must be between 1 and 150 characters")
	String area;
	@Size(min = 1, max = 25, message = "PO-BOX must be between 1 and 25 characters")
	String pobox;
	@Size(min = 1, max = 150, message = "Country must be between 1 and 150 characters")
	String country;
	
	@Email(message = "Email should be valid")
	String email;
	@Pattern(regexp = "^\\d{10,15}$", message = "Phone must be 10 to 15 digits") // 2111234567
	String phone;
	@Pattern(regexp = "^\\d{10,15}$", message = "Mobile phone must be 10 to 15 digits") // 6974777777
	String mobilephone;
	
	@Size(max = 600, message = "Note1 must not be more than 600 characters")
	String note1;
	@Size(max = 600, message = "Note2 must not be more than 600 characters")
	String note2;
	@Size(max = 600, message = "Note3 must not be more than 600 characters")
	String note3;
	
	@Column(updatable=false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	LocalDate created;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	LocalDate updated;
	
	// Relations
    @OneToMany(
            mappedBy = "customer",
            cascade = CascadeType.REMOVE,
            orphanRemoval = true,
            fetch = FetchType.LAZY
        )
    private List<Pet> pets = new ArrayList<>();

	// OnCreate, OnUpdate
	@PrePersist
	public void onCreate() {
		 Instant instant = Instant.now();   
		 this.created = LocalDate.ofInstant(instant, ZoneOffset.UTC);
	}
	
	@PreUpdate
	public void onUpdate() {
		 Instant instant = Instant.now();   
		 this.updated = LocalDate.ofInstant(instant, ZoneOffset.UTC);
	}

	
}
