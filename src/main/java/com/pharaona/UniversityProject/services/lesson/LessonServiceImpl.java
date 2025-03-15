package com.pharaona.UniversityProject.services.lesson;

import com.pharaona.UniversityProject.models.Lesson;
import com.pharaona.UniversityProject.repositories.LessonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LessonServiceImpl implements LessonService {

    private LessonRepository lessonRepository;

    public LessonServiceImpl(LessonRepository theLessonRepository) {
        lessonRepository = theLessonRepository;
    }

    @Override
    public List<Lesson> findAll() {
        return lessonRepository.findAll();
    }

    @Override
    public Lesson save(Lesson theLesson) {
        return lessonRepository.save(theLesson);
    }

    @Override
    public Lesson findById(int theId) {
        Optional<Lesson> result = lessonRepository.findById(theId);

        Lesson theLesson = null;

        if (result.isPresent()) {
            theLesson = result.get();
        }
        else {

            throw new RuntimeException("Did not find lesson id - " + theId);
        }

        return theLesson;
    }

    public void deleteById(int theId) {
        lessonRepository.deleteById((theId));
    }

}
