package com.pharaona.UniversityProject.models.junction;

import com.pharaona.UniversityProject.models.Curriculum;
import com.pharaona.UniversityProject.models.Discipline;
import com.pharaona.UniversityProject.models.Speciality;
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
public class DisciplineCurriculum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int credits;

    private int academicHours;

    private int gradingType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "discipline_id")
    private Discipline discipline;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "curriculum_id")
    private Curriculum curriculum;

}
