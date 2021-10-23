package com.mentzikof.myPetClinic.config.security;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.mentzikof.myPetClinic.model.PetClinicUser;

public class PetClinicUserDetailsPrincipal implements UserDetails {

    private final PetClinicUser user;

    public PetClinicUserDetailsPrincipal(PetClinicUser user) {
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
        return true;
    }

    public PetClinicUser getPetClinicUser() {
        return user;
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return new HashSet<GrantedAuthority>();
	}
}