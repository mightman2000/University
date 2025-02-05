package com.pharaona.UniversityProject.services.teacher_discipline;

import com.pharaona.UniversityProject.models.junction.TeacherDiscipline;
import com.pharaona.UniversityProject.repositories.TeacherDisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherDisciplineServiceImpl implements TeacherDisciplineService {

    @Autowired
    private TeacherDisciplineRepository teacherDisciplineRepository;

    public TeacherDisciplineServiceImpl(TeacherDisciplineRepository teacherDisciplineRepository) {
        this.teacherDisciplineRepository = teacherDisciplineRepository;
    }

    @Override
    public TeacherDiscipline save(TeacherDiscipline teacherDiscipline) {
        return teacherDisciplineRepository.save(teacherDiscipline);
    }
}
