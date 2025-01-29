package com.pharaona.UniversityProject.services.teacher;

import com.pharaona.UniversityProject.models.Speciality;
import com.pharaona.UniversityProject.models.Teacher;
import com.pharaona.UniversityProject.repositories.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository theTeacherRepository) {
        teacherRepository = theTeacherRepository;
    }

    @Override
    public List<Teacher> findAllWithDepartments() {
        return teacherRepository.findAllWithDepartments();
    }

    @Override
    public Teacher save(Teacher theTeacher) {
        return teacherRepository.save(theTeacher);
    }

    @Override
    public void deleteById(int theId) {
        teacherRepository.deleteById((theId));
    }
}
