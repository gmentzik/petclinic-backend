package com.mentzikof.myPetClinic.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Lob;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pethistory")
@Getter @Setter @NoArgsConstructor
public class PetHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="pet_id")
	Pet pet;
	String date;
	@Lob
	@Column(name="text", columnDefinition = "TEXT")
	String text;
	@Column(updatable=false)
	Date created;
	Date updated;

	@PrePersist
	public void onCreate() {
		this.created = new Date();
	}
	
	@PreUpdate
	public void onUpdate() {
		this.updated = new Date();
	}
}
