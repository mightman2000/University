package com.pharaona.UniversityProject.repositories;

import com.pharaona.UniversityProject.models.Assignment;
import com.pharaona.UniversityProject.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
