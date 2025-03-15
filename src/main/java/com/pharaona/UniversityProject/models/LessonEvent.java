package com.pharaona.UniversityProject.models;

import com.pharaona.UniversityProject.models.utils.LessonType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class LessonEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @OneToMany(mappedBy = "lessonEvent", cascade = CascadeType.ALL)
    private List<Material> materials;

    @OneToMany(mappedBy = "lessonEvent", cascade = CascadeType.ALL)
    private List<Assignment> assignments;

    private LocalDate startTime;

    private LocalDate endTime;

    private LessonType type;
}
