package com.pharaona.UniversityProject.services.question;

import com.pharaona.UniversityProject.models.Question;

import java.util.List;

public interface QuestionService {

    List<Question> findAll();

    Question save(Question theQuestion);

    Question findById(int theId);

    void deleteById(int theId);

}
