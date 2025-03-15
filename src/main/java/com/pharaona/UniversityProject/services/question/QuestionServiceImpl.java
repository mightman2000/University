package com.pharaona.UniversityProject.services.question;

import com.pharaona.UniversityProject.models.Question;
import com.pharaona.UniversityProject.repositories.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository theQuestionRepository) {
        questionRepository = theQuestionRepository;
    }

    @Override
    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    @Override
    public Question save(Question theQuestion) {
        return questionRepository.save(theQuestion);
    }

    @Override
    public Question findById(int theId) {
        Optional<Question> result = questionRepository.findById(theId);

        Question theQuestion = null;

        if (result.isPresent()) {
            theQuestion = result.get();
        }
        else {

            throw new RuntimeException("Did not find question id - " + theId);
        }

        return theQuestion;
    }

    public void deleteById(int theId) {
        questionRepository.deleteById((theId));
    }

}
