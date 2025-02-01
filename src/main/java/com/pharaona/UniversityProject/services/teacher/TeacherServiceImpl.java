package com.pharaona.UniversityProject.services.teacher;

import com.pharaona.UniversityProject.models.Speciality;
import com.pharaona.UniversityProject.models.Teacher;
import com.pharaona.UniversityProject.repositories.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Teacher findById(int theId) {
        Optional<Teacher> result = teacherRepository.findById(theId);

        Teacher teacher = null;

        if (result.isPresent()) {
            teacher = result.get();
        }
        else {
            throw new RuntimeException("Did not find teacher id - " + theId);
        }
        return teacher;
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
