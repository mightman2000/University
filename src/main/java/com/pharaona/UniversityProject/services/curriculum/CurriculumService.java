package com.pharaona.UniversityProject.services.curriculum;

import com.pharaona.UniversityProject.models.Curriculum;
import com.pharaona.UniversityProject.models.Department;

import java.util.List;

public interface CurriculumService {

    public List<Curriculum> findAllWithDisciplines();

    void deleteById(int theId);

}
