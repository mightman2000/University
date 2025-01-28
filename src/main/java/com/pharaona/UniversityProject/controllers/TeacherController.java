package com.pharaona.UniversityProject.controllers;

import com.pharaona.UniversityProject.models.Teacher;
import com.pharaona.UniversityProject.repositories.TeacherRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    private TeacherRepository teacherRepository;

    public TeacherController(TeacherRepository TheteacherRepository) {
        teacherRepository = TheteacherRepository;
    }

    @GetMapping("/overview")
    public String listOfTeachers(Model theModel){

        List<Teacher> teachers = teacherRepository.findAllWithDepartments();
        theModel.addAttribute("teacher", teachers);

        return "teacher/overview";
    }


}
