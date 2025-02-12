package com.pharaona.UniversityProject.services.discipline_curriculum;

import com.pharaona.UniversityProject.models.junction.DisciplineCurriculum;
import com.pharaona.UniversityProject.repositories.DisciplineCurriculumRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplineCurriculumServiceImpl implements DisciplineCurriculumService {

    private DisciplineCurriculumRepository disciplineCurriculumRepository;

    public DisciplineCurriculumServiceImpl(DisciplineCurriculumRepository theDisciplineCurriculumRepository) {
        disciplineCurriculumRepository = theDisciplineCurriculumRepository;
    }

    @Override
    public List<DisciplineCurriculum> findAll() {
        return disciplineCurriculumRepository.findAll();
    }
}
