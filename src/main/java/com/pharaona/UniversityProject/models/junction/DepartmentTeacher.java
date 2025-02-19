package com.pharaona.UniversityProject.models.junction;

import com.pharaona.UniversityProject.models.Department;
import com.pharaona.UniversityProject.models.Teacher;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
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
}
