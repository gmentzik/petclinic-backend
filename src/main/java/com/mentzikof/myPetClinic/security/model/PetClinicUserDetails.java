package com.mentzikof.myPetClinic.security.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.mentzikof.myPetClinic.model.PetClinicUser;
import com.mentzikof.myPetClinic.model.Role;


public class PetClinicUserDetails implements UserDetails {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5568243977099800450L;
	
	
	private final PetClinicUser user;

    public PetClinicUserDetails(PetClinicUser user) {
        this.user = user;
    }

	@Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.isEnabled();
    }

    public PetClinicUser getPetClinicUser() {
        return user;
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<Role> roles = user.getRoles();
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		
		for (Role role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		
		return authorities;
	}
}