package com.pharaona.UniversityProject.services.student_group;

import com.pharaona.UniversityProject.models.Student;
import com.pharaona.UniversityProject.models.StudentGroup;

import java.util.List;

public interface StudentGroupService {

    List<StudentGroup> findAll();

    StudentGroup save(StudentGroup studentGroup);

    StudentGroup findById(int theId);

    void deleteById(int theId);

}
