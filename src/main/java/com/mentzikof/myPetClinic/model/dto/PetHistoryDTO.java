package com.mentzikof.myPetClinic.model.dto;

import java.util.ArrayList;
import java.util.List;

import com.mentzikof.myPetClinic.model.PetHistory;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class PetHistoryDTO {
	
	String customerFullName;
	String petName;
	String species;
	String gender;
	List<PetHistory> petHistory = new ArrayList<>();	
	
}
