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
public class StudentGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String groupNumber;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false) // Foreign Key to Course
    private Course course;

}
