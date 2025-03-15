package com.pharaona.UniversityProject.models.junction;

import com.pharaona.UniversityProject.models.Discipline;
import com.pharaona.UniversityProject.models.Question;
import com.pharaona.UniversityProject.models.Teacher;
import com.pharaona.UniversityProject.models.TestInstance;
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
public class TestInstanceQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int testInstanceQuestionId;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "test_instance_id")
    private TestInstance testInstance;

    private String[] givenAnswers;
}
