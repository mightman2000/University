package com.pharaona.UniversityProject.repositories;

import com.pharaona.UniversityProject.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
