package com.pharaona.UniversityProject.services.teacher;

import com.pharaona.UniversityProject.models.Speciality;
import com.pharaona.UniversityProject.models.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> findAllWithDepartments();

    public Teacher findById(int theId);

    List<Teacher> findAll();

    List<Teacher> findAllById(List<Integer> theIds);

    public Teacher save(Teacher theTeacher);

    void deleteById(int theId);
}
