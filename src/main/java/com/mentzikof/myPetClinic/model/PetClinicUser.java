package com.mentzikof.myPetClinic.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.mentzikof.myPetClinic.model.validator.EnumValidator;

import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "user")
@NoArgsConstructor
@Data
public class PetClinicUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@NotBlank(message = "username is required")
	String username;
	@NotBlank(message = "password is required")
	String password;
	private boolean enabled;
    @Transient
    private String confirmPassword;
    @Transient
    @EnumValidator(
    	     enumClazz = RolesEnum.class,
    	     message = "Unsupported user role value"
    	 )
    private String newUserRole;
//    https://www.baeldung.com/jpa-many-to-many
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
			name = "users_roles",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id")
			)
	private Set<Role> roles = new HashSet<>();

//	To hide some fields at response you can use @JsonIgnore on the getter of the field that you want to hide 
//	but don't forget to add @JsonSetter on the setter of that field 
	
	@JsonIgnore
	public String getConfirmPassword() {
		return confirmPassword;
	}
	@JsonSetter
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	@JsonIgnore
	public String getNewUserRole() {
		return newUserRole;
	}
	@JsonSetter
	public void setNewUserRole(String newUserRole) {
		this.newUserRole = newUserRole;
	}
	
}
