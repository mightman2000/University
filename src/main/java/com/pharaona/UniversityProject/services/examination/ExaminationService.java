package com.pharaona.UniversityProject.services.examination;

import com.pharaona.UniversityProject.models.Examination;

import java.util.List;

public interface ExaminationService {

    List<Examination> findAll();

    Examination save(Examination theExamination);

    Examination findById(int theId);

    void deleteById(int theId);

}
