package com.pharaona.UniversityProject.repositories;

import com.pharaona.UniversityProject.models.Lesson;
import com.pharaona.UniversityProject.models.LessonEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonEventRepository extends JpaRepository<LessonEvent, Integer> {
}
