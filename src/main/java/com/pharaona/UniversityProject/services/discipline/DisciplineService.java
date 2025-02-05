package com.pharaona.UniversityProject.services.discipline;

import com.pharaona.UniversityProject.models.Discipline;

import java.util.List;

public interface DisciplineService {

    List<Discipline> findAll();

    Discipline findById(int theId);

    List<Discipline> findAllById(List<Integer> theIds) ;

    Discipline save(Discipline theDiscipline);

    void deleteById(int theId);


}
