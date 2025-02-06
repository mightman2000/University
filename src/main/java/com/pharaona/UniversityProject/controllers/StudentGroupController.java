package com.pharaona.UniversityProject.controllers;

import com.pharaona.UniversityProject.models.Course;
import com.pharaona.UniversityProject.models.StudentGroup;
import com.pharaona.UniversityProject.services.course.CourseService;
import com.pharaona.UniversityProject.services.student_group.StudentGroupService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/studentGroup")
public class StudentGroupController {

    private StudentGroupService studentGroupService;
    private CourseService courseService;

    public StudentGroupController(StudentGroupService theStudentGroupService, CourseService theCourseService) {
        studentGroupService = theStudentGroupService;
        courseService = theCourseService;
    }

    @GetMapping("/overview")
    public String listOfStudentGroups(Model theModel) {

        List<StudentGroup> studentGroups = studentGroupService.findAll();
        theModel.addAttribute("studentGroup", studentGroups);

        return "/student_group/overview";
    }

    @GetMapping("/add")
    public String showAddForm(Model theModel) {

        StudentGroup studentGroup = new StudentGroup();
        theModel.addAttribute("studentGroup", studentGroup);

        //fetch all courses
        List<Course> courses = courseService.findAll();
        theModel.addAttribute("course", courses);


        return "/student_group/add-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("studentGroup") StudentGroup theStudentGroup, @RequestParam("course") int theId) {

        Course selectedCourse = courseService.findById(theId);
        theStudentGroup.setCourse(selectedCourse);

        studentGroupService.save(theStudentGroup);

        return "redirect:/studentGroup/overview";
    }

    @GetMapping("/update")
    public String update(@RequestParam("studentGroupId")int theId, Model theModel) {

        StudentGroup studentGroup = studentGroupService.findById(theId);
        theModel.addAttribute("studentGroup", studentGroup);

        //fetch courses
        List<Course> courses = courseService.findAll();
        theModel.addAttribute("course", courses);

        return "/student_group/add-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("studentGroupId") int theId) {

        studentGroupService.deleteById(theId);

        return "redirect:/studentGroup/overview";
    }




}
