package com.pharaona.UniversityProject.controllers;

import com.pharaona.UniversityProject.models.Department;
import com.pharaona.UniversityProject.models.Discipline;
import com.pharaona.UniversityProject.models.Teacher;
import com.pharaona.UniversityProject.models.junction.DepartmentTeacher;
import com.pharaona.UniversityProject.models.junction.TeacherDiscipline;
import com.pharaona.UniversityProject.services.department.DepartmentService;
import com.pharaona.UniversityProject.services.department_teacher.DepartmentTeacherService;
import com.pharaona.UniversityProject.services.discipline.DisciplineService;
import com.pharaona.UniversityProject.services.teacher.TeacherService;
import com.pharaona.UniversityProject.services.teacher_discipline.TeacherDisciplineService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    private TeacherService teacherService;
    private DepartmentService departmentService;
    private DisciplineService disciplineService;
    private DepartmentTeacherService departmentTeacherService;
    private TeacherDisciplineService teacherDisciplineService;

    public TeacherController(TeacherService theTeacherService, DepartmentService theDepartmentService, DisciplineService theDisciplineService, DepartmentTeacherService theDepartmentTeacherService, TeacherDisciplineService theTeacherDisciplineService) {
        teacherService = theTeacherService;
        departmentService = theDepartmentService;
        disciplineService = theDisciplineService;
        departmentTeacherService = theDepartmentTeacherService;
        teacherDisciplineService = theTeacherDisciplineService;
    }

    @GetMapping("/overview")
    public String listOfTeachers(Model theModel){

        List<Teacher> teachers = teacherService.findAllWithDepartments();
        theModel.addAttribute("teacher", teachers);

        return "teacher/overview";
    }

    @GetMapping("/add")
    public String showAddForm(Model theModel){

        Teacher theTeacher = new Teacher();
        List<Department> theDepartments = departmentService.findAll();
        List<Discipline> theDisciplines = disciplineService.findAll();
        theModel.addAttribute("teacher", theTeacher);
        theModel.addAttribute("department", theDepartments);
        theModel.addAttribute("discipline", theDisciplines);

        return "/teacher/add-form";
    }

    @PostMapping("/save")
    public String saveTeacher(@ModelAttribute("teacher") Teacher theTeacher,
                              @RequestParam("department") int departmentId,
                              @RequestParam("disciplines") List<Integer> disciplineIds) {

        // Step 1: Save the teacher first
        teacherService.save(theTeacher); // Generates an ID

        // Step 2: Find the selected department
        Department selectedDepartment = departmentService.findById(departmentId);

        // Step 3: Create the junction entry
        DepartmentTeacher departmentTeacher = new DepartmentTeacher();
        departmentTeacher.setTeacher(theTeacher);
        departmentTeacher.setDepartment(selectedDepartment);
        departmentTeacherService.save(departmentTeacher);

        List<Discipline> selectedDisciplines = disciplineService.findAllById(disciplineIds);
        for (Discipline selectedDiscipline : selectedDisciplines){
            TeacherDiscipline teacherDiscipline = new TeacherDiscipline();
            teacherDiscipline.setTeacher(theTeacher);
            teacherDiscipline.setDiscipline(selectedDiscipline);
            teacherDisciplineService.save(teacherDiscipline); // Save relationship
        }

        return "redirect:/teacher/overview";
    }

    @GetMapping("/update")
    public String update(@RequestParam ("teacherId") int theId, Model theModel){

        Teacher theTeacher = teacherService.findById(theId);
        theModel.addAttribute("teacher", theTeacher);

        List<Department> theDepartment = departmentService.findAll();
        theModel.addAttribute("department", theDepartment);

        return "teacher/add-form";
    }

    @GetMapping("/delete")
    public String showAddForm(@RequestParam ("teacherId") int theId){
        teacherService.deleteById(theId);

        return "redirect:/teacher/overview";
    }
}
