package com.pharaona.UniversityProject.security;

import com.pharaona.UniversityProject.enums.Role;
import com.pharaona.UniversityProject.models.AppUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

//represent the logged user.

public class CustomUserDetails implements UserDetails {

    private final AppUser appUser;

    public CustomUserDetails(AppUser appUser) {
        this.appUser = appUser;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { // added gpt
        return List.of(new SimpleGrantedAuthority("ROLE_" + appUser.getRole().name())); // added gpt
    } // added gpt

    @Override
    public String getPassword() {
        return appUser.getPassword();
    }

    @Override
    public String getUsername() {
        return appUser.getEmail();
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

    public String getFirstName() {
        return appUser.getFirstName();
    }

    public String getLastName() {
        return appUser.getLastName();
    }

    public Role getRole() { // added gpt
        return appUser.getRole(); // added gpt
    } // added gpt

}
