package com.pharaona.UniversityProject.services.faculty;

import com.pharaona.UniversityProject.models.Faculty;

import java.util.List;

public interface FacultyService {

    List<Faculty> findAll();

    Faculty findById(int theId);

    Faculty save(Faculty theFaculty);

    void deleteById(int theId);

    public boolean isEmailUnique(String email);

}
