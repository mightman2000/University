package com.pharaona.UniversityProject.models;

import com.pharaona.UniversityProject.models.junction.DisciplineCurriculum;
import com.pharaona.UniversityProject.models.junction.TeacherDiscipline;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Discipline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "discipline", cascade = CascadeType.ALL)
    private List<TeacherDiscipline> teacherDiscipline;

    @OneToMany(mappedBy = "discipline", cascade = CascadeType.ALL)
    private List<DisciplineCurriculum> disciplineCurriculums;

    @OneToMany(mappedBy = "discipline", cascade = CascadeType.ALL)
    private List<Lesson> lessons;

    public String getTeachersNames(){
        return  teacherDiscipline.stream().map(x -> x.getTeacher().getFullName()).collect(Collectors.joining(", "));
    }

}
