package com.pharaona.UniversityProject.services.test;

import com.pharaona.UniversityProject.models.*;
import com.pharaona.UniversityProject.models.junction.TestInstanceQuestion;
import com.pharaona.UniversityProject.repositories.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TestServiceImpl implements TestService {

    private TestRepository testRepository;
    private QuestionGroupRepository questionGroupRepository;
    private QuestionRepository questionRepository;
    private StudentRepository studentRepository;
    private TestInstanceRepository testInstanceRepository;
    private TestInstanceQuestionRepository testInstanceQuestionRepository;

    public TestServiceImpl(TestRepository theTestRepository, QuestionGroupRepository theQuestionGroupRepository, QuestionRepository theQuestionRepository, StudentRepository theStudentRepository, TestInstanceRepository theTestInstanceRepository, TestInstanceQuestionRepository theTestInstanceQuestionRepository) {
        testRepository = theTestRepository;
        questionGroupRepository = theQuestionGroupRepository;
        questionRepository = theQuestionRepository;
        studentRepository = theStudentRepository;
        testInstanceRepository = theTestInstanceRepository;
        testInstanceQuestionRepository = theTestInstanceQuestionRepository;
    }

    @Override
    public List<Test> findAll() {
        return testRepository.findAll();
    }

    @Override
    public Test save(Test theTest) {
        Test result = testRepository.save(theTest);
        for (QuestionGroup qg : theTest.getQuestionGroups()){
            qg.setTest(theTest);
            questionGroupRepository.save(qg);
            for (Question q : qg.getQuestions()){
                q.setQuestionGroup(qg);
                questionRepository.save(q);
            }
        }

        return result;
    }

    @Override
    public Test findById(int theId) {
        Optional<Test> result = testRepository.findById(theId);

        Test theTest = null;

        if (result.isPresent()) {
            theTest = result.get();
        }
        else {

            throw new RuntimeException("Did not find test id - " + theId);
        }

        return theTest;
    }

    public void deleteById(int theId) {
        testRepository.deleteById((theId));
    }

    @Override
    public TestInstance generateTest(int testId, int studentId) {
        TestInstance testInstance = new TestInstance();
        Test test = testRepository.findById(testId).get();
        Student student = studentRepository.findById(studentId).get();

        List<TestInstanceQuestion> questions= new ArrayList<TestInstanceQuestion>();
        List<QuestionGroup> questionGroups = test.getQuestionGroups();
        if(test.isRandomized()){
            for (QuestionGroup qg : questionGroups){
                List<Question> questionsFromGroup = qg.getQuestions();
                Random studentSeed = new Random(student.getId());
                Collections.shuffle(questionsFromGroup, studentSeed);
                questions.addAll(questionsFromGroup.subList(0,qg.getCount()).stream().map(x->
                {
                    TestInstanceQuestion testInstanceQuestion = new TestInstanceQuestion();
                    testInstanceQuestion.setQuestion(x);
                    testInstanceQuestion.setTestInstance(testInstance);
                    return  testInstanceQuestion;
                }).toList());
            }
        }
        testInstance.setQuestions(questions);
        testInstanceRepository.save(testInstance);
        testInstanceQuestionRepository.saveAll(questions);

        return testInstance;
    }

}
