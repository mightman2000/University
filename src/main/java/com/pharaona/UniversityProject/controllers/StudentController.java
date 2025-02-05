package com.pharaona.UniversityProject.controllers;

import com.pharaona.UniversityProject.models.Course;
import com.pharaona.UniversityProject.models.Department;
import com.pharaona.UniversityProject.models.Speciality;
import com.pharaona.UniversityProject.models.Student;
import com.pharaona.UniversityProject.services.course.CourseService;
import com.pharaona.UniversityProject.services.student.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    private StudentService studentService;
    private CourseService courseService;

    public StudentController(StudentService theStudentService, CourseService theCourseService) {
        studentService = theStudentService;
        courseService = theCourseService;
    }

    @GetMapping("/overview")
    public String listOfStudents(Model model) {

        List<Student> students = studentService.findAll();
        model.addAttribute("student", students);

        return "student/overview";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {

        Student student = new Student();
        model.addAttribute("student", student);

        //fetch all courses
        List<Course> courses = courseService.findAll();
        model.addAttribute("course", courses);

        return "student/add-form";
    }

    @PostMapping("/save")
    public String save (@ModelAttribute("student") Student theStudent, @RequestParam("course") int courseId){

        Course selectedCourse = courseService.findById(courseId);

        theStudent.setCourse(selectedCourse);

        studentService.save(theStudent);

        return "redirect:/student/overview";
    }

    @GetMapping("/update")
    public String update(@RequestParam("studentId") int theId, Model theModel){

        Student theStudent = studentService.findById(theId);
        theModel.addAttribute("student", theStudent);

        //fetch all departments to fill and display the dropdown
        List<Course> theCourse = courseService.findAll();
        theModel.addAttribute("course", theCourse);

        return "/student/add-form";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam("studentId") int theId){

        studentService.deleteById(theId);

        return "redirect:/student/overview";
    }

}
