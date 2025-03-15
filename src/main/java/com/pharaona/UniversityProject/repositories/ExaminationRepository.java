package com.pharaona.UniversityProject.repositories;

import com.pharaona.UniversityProject.models.Examination;
import com.pharaona.UniversityProject.models.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExaminationRepository extends JpaRepository<Examination, Integer> {
}
