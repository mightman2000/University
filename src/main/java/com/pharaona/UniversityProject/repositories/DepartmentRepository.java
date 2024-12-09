package com.pharaona.UniversityProject.repositories;


import com.pharaona.UniversityProject.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
