package com.pharaona.UniversityProject.repositories;

import com.pharaona.UniversityProject.models.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository extends JpaRepository<Faculty, Integer> {

    Faculty findByEmail(String email);

}
