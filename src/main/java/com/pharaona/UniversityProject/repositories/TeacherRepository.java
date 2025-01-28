package com.pharaona.UniversityProject.repositories;

import com.pharaona.UniversityProject.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}
