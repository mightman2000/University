package com.pharaona.UniversityProject.models;

import com.pharaona.UniversityProject.models.junction.DepartmentTeacher;
import com.pharaona.UniversityProject.models.junction.TeacherDiscipline;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private LocalDate dateJoined;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<DepartmentTeacher> departmentTeachers;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<TeacherDiscipline> teacherDiscipline;

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
