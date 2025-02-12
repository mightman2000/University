package com.pharaona.UniversityProject.models;

import com.pharaona.UniversityProject.models.junction.DisciplineCurriculum;
import com.pharaona.UniversityProject.models.junction.TeacherDiscipline;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Curriculum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "speciality_id")
    private Speciality speciality;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "curriculum", cascade = CascadeType.ALL)
    private List<DisciplineCurriculum> disciplineCurriculums;

}
