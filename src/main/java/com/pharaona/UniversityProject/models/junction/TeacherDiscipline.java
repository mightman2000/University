package com.pharaona.UniversityProject.models.junction;

import com.pharaona.UniversityProject.models.Discipline;
import com.pharaona.UniversityProject.models.Teacher;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TeacherDiscipline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teacherDisciplineId;

    @ManyToOne
    @JoinColumn(name = "discipline_id", nullable = false)
    private Discipline discipline;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;
}
