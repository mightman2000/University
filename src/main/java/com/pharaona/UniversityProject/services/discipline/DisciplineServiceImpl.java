package com.pharaona.UniversityProject.services.discipline;

import com.pharaona.UniversityProject.models.Discipline;
import com.pharaona.UniversityProject.repositories.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplineServiceImpl implements DisciplineService {

    private DisciplineRepository disciplineRepository;

    @Autowired
    public DisciplineServiceImpl(DisciplineRepository theDisciplineRepository) {
        disciplineRepository = theDisciplineRepository;
    }

    @Override
    public List<Discipline> findAll() {
        return disciplineRepository.findAll();
    }

    @Override
    public Discipline findById(int theId) {
        Optional<Discipline> result = disciplineRepository.findById(theId);

        Discipline discipline = null;

        if (result.isPresent()) {
            discipline = result.get();
        }
        else {
            throw new RuntimeException("Did not find discipline id - " + theId);
        }
        return discipline;
    }

    @Override
    public List<Discipline> findAllById(List<Integer> theIds) {
        return disciplineRepository.findAllById(theIds);
    }

    @Override
    public Discipline save(Discipline theDiscipline) {
       return disciplineRepository.save(theDiscipline);
    }

    @Override
    public void deleteById(int theId) {
        disciplineRepository.deleteById(theId);
    }
}
