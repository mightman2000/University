package com.pharaona.UniversityProject.services.lessonEvent;

import com.pharaona.UniversityProject.models.LessonEvent;
import com.pharaona.UniversityProject.repositories.LessonEventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LessonEventServiceImpl implements LessonEventService {

    private LessonEventRepository lessonEventRepository;

    public LessonEventServiceImpl(LessonEventRepository theLessonEventRepository) {
        lessonEventRepository = theLessonEventRepository;
    }

    @Override
    public List<LessonEvent> findAll() {
        return lessonEventRepository.findAll();
    }

    @Override
    public LessonEvent save(LessonEvent theLessonEvent) {
        return lessonEventRepository.save(theLessonEvent);
    }

    @Override
    public LessonEvent findById(int theId) {
        Optional<LessonEvent> result = lessonEventRepository.findById(theId);

        LessonEvent theLessonEvent = null;

        if (result.isPresent()) {
            theLessonEvent = result.get();
        }
        else {

            throw new RuntimeException("Did not find lessonEvent id - " + theId);
        }

        return theLessonEvent;
    }

    public void deleteById(int theId) {
        lessonEventRepository.deleteById((theId));
    }

}
