package com.pharaona.UniversityProject.controllers;

import com.pharaona.UniversityProject.models.Discipline;
import com.pharaona.UniversityProject.models.Teacher;
import com.pharaona.UniversityProject.models.junction.TeacherDiscipline;
import com.pharaona.UniversityProject.services.discipline.DisciplineService;
import com.pharaona.UniversityProject.services.teacher.TeacherService;
import com.pharaona.UniversityProject.services.teacher_discipline.TeacherDisciplineService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/discipline")
public class DisciplineController {

    private DisciplineService disciplineService;
    private TeacherService teacherService;
    private TeacherDisciplineService teacherDisciplineService;

    public DisciplineController(DisciplineService disciplineService, TeacherService teacherService, TeacherDisciplineService teacherDisciplineService) {
        this.disciplineService = disciplineService;
        this.teacherService = teacherService;
        this.teacherDisciplineService = teacherDisciplineService;
    }

    @GetMapping("/overview")
    public String listOfDiscipline(Model theModel){
        List<Discipline> teachers = disciplineService.findAll();
        theModel.addAttribute("discipline", teachers);

        return "discipline/overview";
    }

    @GetMapping("/add")
    public String showAddForm(Model theModel){
        Discipline theDiscipline = new Discipline();
        List<Teacher> theTeachers = teacherService.findAll();

        theModel.addAttribute("discipline", theDiscipline);
        theModel.addAttribute("teacher", theTeachers);

        return "/discipline/add-form";
    }

    @PostMapping("/save")
    public String saveTeacher(@ModelAttribute("discipline") Discipline theDiscipline,
                              @RequestParam("teachers") List<Integer> teacherIds) {
        disciplineService.save(theDiscipline);

        List<Teacher> selectedTeachers = teacherService.findAllById(teacherIds);
        for (Teacher selectedTeacher : selectedTeachers){
            TeacherDiscipline teacherDiscipline = new TeacherDiscipline();
            teacherDiscipline.setTeacher(selectedTeacher);
            teacherDiscipline.setDiscipline(theDiscipline);
            teacherDisciplineService.save(teacherDiscipline); // Save relationship
        }

        return "redirect:/discipline/overview";
    }

    //add the html stuff
    @GetMapping("/delete")
    public String delete(@RequestParam ("disciplineId") int theId){
        disciplineService.deleteById(theId);

        return "redirect:/discipline/overview";
    }
}
