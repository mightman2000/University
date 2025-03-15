package com.pharaona.UniversityProject.repositories;

import com.pharaona.UniversityProject.models.QuestionGroup;
import com.pharaona.UniversityProject.models.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionGroupRepository extends JpaRepository<QuestionGroup, Integer> {
}
