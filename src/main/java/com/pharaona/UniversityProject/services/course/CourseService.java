package com.pharaona.UniversityProject.services.course;

import com.pharaona.UniversityProject.models.Course;
import com.pharaona.UniversityProject.models.Department;
import com.pharaona.UniversityProject.models.Speciality;

import javax.swing.plaf.PanelUI;
import java.util.List;

public interface CourseService {

    List<Course> findAll();

    Course save(Course theCourse);

    Course findById(int theId);

    void deleteById(int theId);

}
