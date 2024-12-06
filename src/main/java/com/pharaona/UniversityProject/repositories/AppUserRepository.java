package com.pharaona.UniversityProject.repositories;

import com.pharaona.UniversityProject.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Integer> {

    public AppUser findByEmail(String email);

}
