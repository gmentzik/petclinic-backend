package com.mentzikof.myPetClinic.model.dto;

import java.util.Comparator;

import com.mentzikof.myPetClinic.model.PetHistory;

public class PetHistoryCreationDateComparator implements Comparator<PetHistory>
{
    // Used for sorting in ascending order of
    // roll number
    public int compare(PetHistory a, PetHistory b)
    {
    	
    	if (a.getCreated().isAfter(b.getCreated())) {
    		return -1;
    	} else if (a.getCreated().isBefore(b.getCreated())) {
    		return 1;
    	} else {
    		if (a.getId() > b.getId()) {
    			return -1;
    		} else {
    			return 1;
    		}
    	}
    }


}