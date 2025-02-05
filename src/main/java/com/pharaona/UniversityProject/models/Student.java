package com.pharaona.UniversityProject.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; //faculty number?

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;


}
