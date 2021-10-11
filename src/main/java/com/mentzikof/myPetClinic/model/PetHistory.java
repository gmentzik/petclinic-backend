package com.mentzikof.myPetClinic.model;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@JsonIgnore
	Pet pet;
	String date;
	@Lob
	@Column(name="text", columnDefinition = "TEXT")
	String text;
	@Column(updatable=false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	LocalDate created;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	LocalDate updated;

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
