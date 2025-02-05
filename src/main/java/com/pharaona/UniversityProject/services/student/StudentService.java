package com.pharaona.UniversityProject.services.student;

import com.pharaona.UniversityProject.models.Course;
import com.pharaona.UniversityProject.models.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    Student save(Student theStudent);

    Student findById(int theId);

    void deleteById(int theId);

}
