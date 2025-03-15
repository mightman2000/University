package com.pharaona.UniversityProject.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Dictionary;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @OneToOne
//    @JoinColumn(name = "exam_id", nullable = true)
//    private Examination examination;

    private String name;

    @OneToMany(mappedBy = "test", cascade = CascadeType.ALL)
    private List<QuestionGroup> questionGroups;

    private boolean randomized;
}
