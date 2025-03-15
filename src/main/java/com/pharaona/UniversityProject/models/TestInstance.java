package com.pharaona.UniversityProject.models;

import com.pharaona.UniversityProject.models.junction.TestInstanceQuestion;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TestInstance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "testInstance", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TestInstanceQuestion> questions;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
