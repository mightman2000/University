package com.pharaona.UniversityProject.controllers;

import com.pharaona.UniversityProject.models.Course;
import com.pharaona.UniversityProject.models.Faculty;
import com.pharaona.UniversityProject.models.Speciality;
import com.pharaona.UniversityProject.services.course.CourseService;
import com.pharaona.UniversityProject.services.specialty.SpecialtyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {

    private CourseService courseService;
    private SpecialtyService specialtyService;

    public CourseController(CourseService theCourseService, SpecialtyService theSpecialtyService) {
        courseService = theCourseService;
        specialtyService = theSpecialtyService;
    }

    @GetMapping("/overview")
    public String listOfCourses(Model theModel) {

        List<Course> courses = courseService.findAll();
        theModel.addAttribute("course", courses);

        return "course/overview";
    }

    @GetMapping("/add")
    public String showAddForm(Model theModel) {

        Course theCourse = new Course();
        theModel.addAttribute("course", theCourse);

        List<Speciality> specialities = specialtyService.findAll();
        theModel.addAttribute("speciality", specialities);

        return "course/add-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("course") Course theCourse, @RequestParam("speciality") int specialityId) {

        // Fetch the selected speciality by its ID
        Speciality selectedSpeciality = specialtyService.findById(specialityId);

        // Set the speciality in the Course
        theCourse.setSpeciality(selectedSpeciality);

        courseService.save(theCourse);

        return "redirect:/course/overview";
    }

    @GetMapping("/update")
    public String update(@RequestParam ("courseId") int courseId, Model theModel) {

        //fetch the selected course to update
        Course theCourse = courseService.findById(courseId);
        theModel.addAttribute("course", theCourse);


        //fetch list of specialities
        List<Speciality> theSpeciality = specialtyService.findAll();
        theModel.addAttribute("speciality", theSpeciality);


        return "/course/add-form";
    }

    //request param reads from http body
    @GetMapping("/delete")
    public String delete(@RequestParam("courseId") int theId) {

        courseService.deleteById(theId);

        return "redirect:/course/overview";
    }



}
