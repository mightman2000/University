package com.pharaona.UniversityProject.models;

import com.pharaona.UniversityProject.models.junction.DepartmentTeacher;
import com.pharaona.UniversityProject.models.junction.TeacherDiscipline;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Teacher {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private LocalDate dateJoined;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<DepartmentTeacher> departmentTeachers;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<TeacherDiscipline> teacherDiscipline;

    public Teacher() {    }

    public Teacher(int id, String firstName, String lastName, String email, String phoneNumber, LocalDate dateJoined, List<DepartmentTeacher> departmentTeachers, List<TeacherDiscipline> teacherDisciplines) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateJoined = dateJoined;
        this.departmentTeachers = departmentTeachers;
        this.teacherDiscipline = teacherDisciplines;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(LocalDate dateJoined) {
        this.dateJoined = dateJoined;
    }

    public List<DepartmentTeacher> getDepartmentTeachers() {
        return departmentTeachers;
    }

    public List<TeacherDiscipline> getTeacherDiscipline() {
        return teacherDiscipline;
    }

    public void setTeacherDiscipline(List<TeacherDiscipline> teacherDiscipline) {
        this.teacherDiscipline = teacherDiscipline;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
