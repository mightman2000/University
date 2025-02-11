package com.pharaona.UniversityProject.services.department_teacher;

import com.pharaona.UniversityProject.models.junction.DepartmentTeacher;
import com.pharaona.UniversityProject.repositories.DepartmentTeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentTeacherServiceImpl implements DepartmentTeacherService {

    @Autowired
    private DepartmentTeacherRepository departmentTeacherRepository;

    public DepartmentTeacherServiceImpl(DepartmentTeacherRepository theDepartmentTeacherRepository) {
        departmentTeacherRepository = theDepartmentTeacherRepository;
    }


    @Override
    public DepartmentTeacher save(DepartmentTeacher departmentTeacher) {
        return departmentTeacherRepository.save(departmentTeacher);
    }
}
