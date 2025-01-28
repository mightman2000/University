package com.pharaona.UniversityProject.services.specialty;

import com.pharaona.UniversityProject.models.Faculty;
import com.pharaona.UniversityProject.models.Speciality;

import java.util.List;

public interface SpecialtyService {

    List<Speciality> findAll();

    Speciality findById(int theId);

    Speciality save(Speciality theSpecialty);

    public void deleteById(int theId);

}
