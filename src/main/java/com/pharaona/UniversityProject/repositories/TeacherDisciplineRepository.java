package com.pharaona.UniversityProject.repositories;

import com.pharaona.UniversityProject.models.junction.TeacherDiscipline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherDisciplineRepository extends JpaRepository<TeacherDiscipline, Integer> {
}
