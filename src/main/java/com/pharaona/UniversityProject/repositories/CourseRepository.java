package com.pharaona.UniversityProject.repositories;

import com.pharaona.UniversityProject.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
