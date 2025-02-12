package com.pharaona.UniversityProject.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Speciality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String description;

    private int duration;

    private String degreeType;

    private String email;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToMany(mappedBy = "speciality")
    private List<Course> courses;

    @OneToMany(mappedBy = "speciality")
    private List<Curriculum> curriculums;

    public Speciality() {
    }

    public Speciality(int id, String name, String description, int duration, String degreeType, String email, Department department) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.degreeType = degreeType;
        this.email = email;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDegreeType() {
        return degreeType;
    }

    public void setDegreeType(String degreeType) {
        this.degreeType = degreeType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
