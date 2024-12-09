package com.pharaona.UniversityProject.services;

import com.pharaona.UniversityProject.models.Department;
import com.pharaona.UniversityProject.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository theDepartmentRepository) {
        departmentRepository = theDepartmentRepository;
    }


    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department findById(int theId) {
        Optional<Department> result = departmentRepository.findById(theId);

        Department theDepartment = null;

        if (result.isPresent()) {
            theDepartment = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find department id - " + theId);
        }

        return theDepartment;
    }

    @Override
    public Department save(Department theDepartment) {
        return departmentRepository.save(theDepartment);
    }

    @Override
    public void deleteById(int theId) {
        departmentRepository.deleteById((theId));
    }
}
