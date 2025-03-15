package com.pharaona.UniversityProject.services.assignment;

import com.pharaona.UniversityProject.models.Assignment;

import java.util.List;

public interface AssignmentService {

    List<Assignment> findAll();

    Assignment save(Assignment theAssignment);

    Assignment findById(int theId);

    void deleteById(int theId);

}
