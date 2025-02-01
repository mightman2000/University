package com.pharaona.UniversityProject.models;

import jakarta.persistence.*;

@Entity
public class Course {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "specialty_id")
    private Speciality speciality;

    private String academicYear;

}
