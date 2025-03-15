package com.pharaona.UniversityProject.services.lessonEvent;

import com.pharaona.UniversityProject.models.LessonEvent;

import java.util.List;

public interface LessonEventService {

    List<LessonEvent> findAll();

    LessonEvent save(LessonEvent theLessonEvent);

    LessonEvent findById(int theId);

    void deleteById(int theId);

}
