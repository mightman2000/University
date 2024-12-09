package com.pharaona.UniversityProject.services;

import com.pharaona.UniversityProject.models.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> findAll();

    Department findById(int theId);

    Department save(Department theDepartment);

    void deleteById(int theId);

}
