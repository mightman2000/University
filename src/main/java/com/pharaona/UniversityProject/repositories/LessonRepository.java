package com.pharaona.UniversityProject.repositories;

import com.pharaona.UniversityProject.models.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Integer> {
}
