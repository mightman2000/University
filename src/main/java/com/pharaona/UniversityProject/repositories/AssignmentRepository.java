package com.pharaona.UniversityProject.repositories;

import com.pharaona.UniversityProject.models.Assignment;
import com.pharaona.UniversityProject.models.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepository extends JpaRepository<Assignment, Integer> {
}
