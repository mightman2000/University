package com.pharaona.UniversityProject.services.test;

import com.pharaona.UniversityProject.models.Test;
import com.pharaona.UniversityProject.models.TestInstance;

import java.util.List;

public interface TestService {

    List<Test> findAll();

    Test save(Test theTest);

    Test findById(int theId);

    void deleteById(int theId);

    TestInstance generateTest(int testId, int studentId);
}
