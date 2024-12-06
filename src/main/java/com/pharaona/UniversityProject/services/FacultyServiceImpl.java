package com.pharaona.UniversityProject.services;

import com.pharaona.UniversityProject.models.Faculty;
import com.pharaona.UniversityProject.repositories.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyServiceImpl implements FacultyService{

    private FacultyRepository facultyRepository;

    @Autowired
    public FacultyServiceImpl(FacultyRepository theFacultyRepository) {
        facultyRepository = theFacultyRepository;
    }

    @Override
    public List<Faculty> findAll() {
        return facultyRepository.findAll();
    }

    @Override
    public Faculty findById(int theId) {
        Optional<Faculty> result = facultyRepository.findById(theId);

        Faculty faculty = null;

        if (result.isPresent()) {
            faculty = result.get();
        }
        else {
            throw new RuntimeException("Did not find employee id - " + theId);
        }
        return faculty;
    }

    @Override
    public Faculty save(Faculty theFaculty) {
       return facultyRepository.save(theFaculty);
    }

    @Override
    public void deleteById(int theId) {
        facultyRepository.deleteById(theId);
    }
}
