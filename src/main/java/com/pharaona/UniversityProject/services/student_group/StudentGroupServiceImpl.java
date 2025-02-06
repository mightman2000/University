package com.pharaona.UniversityProject.services.student_group;

import com.pharaona.UniversityProject.models.Student;
import com.pharaona.UniversityProject.models.StudentGroup;
import com.pharaona.UniversityProject.repositories.StudentGroupRepository;
import com.pharaona.UniversityProject.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentGroupServiceImpl implements StudentGroupService {

    private StudentGroupRepository studentGroupRepository;

    public StudentGroupServiceImpl(StudentGroupRepository theStudentGroupRepository) {
        studentGroupRepository = theStudentGroupRepository;
    }

    @Override
    public List<StudentGroup> findAll() {
        return studentGroupRepository.findAll();
    }

    @Override
    public StudentGroup save(StudentGroup theStudentGroup) {
        return studentGroupRepository.save(theStudentGroup);
    }

    @Override
    public StudentGroup findById(int theId) {
        Optional<StudentGroup> result = studentGroupRepository.findById(theId);

        StudentGroup theStudentGroup = null;

        if (result.isPresent()) {
            theStudentGroup = result.get();
        }
        else {

            throw new RuntimeException("Did not find studentGroup id - " + theId);
        }

        return theStudentGroup;
    }

    @Override
    public void deleteById(int theId) {
        studentGroupRepository.deleteById(theId);
    }

}
