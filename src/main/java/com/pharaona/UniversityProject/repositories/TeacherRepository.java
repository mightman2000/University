package com.pharaona.UniversityProject.repositories;

import com.pharaona.UniversityProject.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    //fetch teacher and departments from the junction table
    @Query("SELECT t FROM Teacher t LEFT JOIN FETCH t.departmentTeachers dt LEFT JOIN FETCH dt.department")
    List<Teacher> findAllWithDepartments();
}
