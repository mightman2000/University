package com.pharaona.UniversityProject.models;

import com.pharaona.UniversityProject.models.junction.DepartmentTeacher;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String description;

    private String email;

    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Speciality> specialities;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<DepartmentTeacher> departmentTeachers;

}
