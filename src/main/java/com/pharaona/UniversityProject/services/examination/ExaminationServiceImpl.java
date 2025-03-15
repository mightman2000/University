package com.pharaona.UniversityProject.services.examination;

import com.pharaona.UniversityProject.models.Examination;
import com.pharaona.UniversityProject.repositories.ExaminationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExaminationServiceImpl implements ExaminationService {

    private ExaminationRepository examinationRepository;

    public ExaminationServiceImpl(ExaminationRepository theExaminationRepository) {
        examinationRepository = theExaminationRepository;
    }

    @Override
    public List<Examination> findAll() {
        return examinationRepository.findAll();
    }

    @Override
    public Examination save(Examination theExamination) {
        return examinationRepository.save(theExamination);
    }

    @Override
    public Examination findById(int theId) {
        Optional<Examination> result = examinationRepository.findById(theId);

        Examination theExamination = null;

        if (result.isPresent()) {
            theExamination = result.get();
        }
        else {

            throw new RuntimeException("Did not find examination id - " + theId);
        }

        return theExamination;
    }

    public void deleteById(int theId) {
        examinationRepository.deleteById((theId));
    }

}
