package com.pharaona.UniversityProject.services.lesson;

import com.pharaona.UniversityProject.models.Lesson;

import java.util.List;

public interface LessonService {

    List<Lesson> findAll();

    Lesson save(Lesson theLesson);

    Lesson findById(int theId);

    void deleteById(int theId);

}
