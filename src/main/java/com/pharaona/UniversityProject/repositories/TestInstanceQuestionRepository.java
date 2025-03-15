package com.pharaona.UniversityProject.repositories;

import com.pharaona.UniversityProject.models.TestInstance;
import com.pharaona.UniversityProject.models.junction.TestInstanceQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestInstanceQuestionRepository extends JpaRepository<TestInstanceQuestion, Integer> {
}
