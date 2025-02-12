package com.pharaona.UniversityProject.services.curriculum;

import com.pharaona.UniversityProject.models.Curriculum;
import com.pharaona.UniversityProject.repositories.CurriculumRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurriculumServiceImpl implements CurriculumService{

    private CurriculumRepository curriculumRepository;

    public CurriculumServiceImpl(CurriculumRepository theCurriculumRepository) {
        curriculumRepository = theCurriculumRepository;
    }

    @Override
    public List<Curriculum> findAllWithDisciplines() {
       return curriculumRepository.findAllWithDisciplines();
    }

    @Override
    public void deleteById(int theId) {
        curriculumRepository.deleteById(theId);
    }
}
