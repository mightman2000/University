package com.pharaona.UniversityProject.security;

import com.pharaona.UniversityProject.models.AppUser;
import com.pharaona.UniversityProject.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//class for login fucntionality

@Service
public class AppUserService implements UserDetailsService {

    @Autowired
    private AppUserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AppUser appUser = repo.findByEmail(email);

        if (appUser == null) {
            throw new UsernameNotFoundException("User not found");
        }

        //return CustomUserDetails
        return new CustomUserDetails(appUser); // Pass the AppUser object to CustomUserDetails wrapped??
    }
}
