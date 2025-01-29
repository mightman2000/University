package com.pharaona.UniversityProject.services.teacher;

import com.pharaona.UniversityProject.models.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> findAllWithDepartments();

    public Teacher save(Teacher theTeacher);

    void deleteById(int theId);
}
