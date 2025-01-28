package com.pharaona.UniversityProject.models.junction;

import com.pharaona.UniversityProject.models.Department;
import com.pharaona.UniversityProject.models.Teacher;
import jakarta.persistence.*;

@Entity
public class DepartmentTeacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int departmentTeacherId;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;

    public DepartmentTeacher() {
    }

    public DepartmentTeacher(int departmentTeacherId, Department department, Teacher teacher) {
        this.departmentTeacherId = departmentTeacherId;
        this.department = department;
        this.teacher = teacher;
    }

    public int getDepartmentTeacherId() {
        return departmentTeacherId;
    }

    public void setDepartmentTeacherId(int departmentTeacherId) {
        this.departmentTeacherId = departmentTeacherId;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
