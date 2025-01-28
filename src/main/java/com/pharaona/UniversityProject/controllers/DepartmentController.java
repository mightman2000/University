package com.pharaona.UniversityProject.controllers;

import com.pharaona.UniversityProject.models.Department;
import com.pharaona.UniversityProject.models.Faculty;
import com.pharaona.UniversityProject.services.department.DepartmentService;
import com.pharaona.UniversityProject.services.faculty.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    DepartmentService departmentService;

    FacultyService facultyService;

    @Autowired
    public DepartmentController (DepartmentService theDepartmentService, FacultyService theFacultyService){
        this.facultyService = theFacultyService;
        departmentService = theDepartmentService;
    }

    @GetMapping("/overview")
    public String listOfDepartments (Model theModel){

        List<Department> theDepartment = departmentService.findAll();

        theModel.addAttribute("department", theDepartment);

        return "/department/overview";
    }

    @GetMapping("/add")
    public String showAddForm (Model theModel){

        Department theDepartment = new Department();
        theModel.addAttribute("department", theDepartment);

        // Fetch the list of faculties
        List<Faculty> theFaculty = facultyService.findAll();
        theModel.addAttribute("faculty", theFaculty);

        return "/department/add-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("department") Department theDepartment, @RequestParam("faculty") int facultyId){

        // Fetch the selected faculty by its ID
        Faculty selectedFaculty = facultyService.findById(facultyId);

        // Set the faculty in the department
        theDepartment.setFaculty(selectedFaculty);

        departmentService.save(theDepartment);

        return "redirect:/department/overview";
    }

    @GetMapping("/update")
    public String update(@RequestParam ("departmentId") int theId, Model theModel){

        Department theDepartment = departmentService.findById(theId);
        theModel.addAttribute(theDepartment);

        // Fetch the list of faculties
        List<Faculty> theFaculty = facultyService.findAll();
        theModel.addAttribute("faculty", theFaculty);

        return "/department/add-form";
    }

    @GetMapping("/delete")
    public String delete (@RequestParam("departmentId") int theId){

        departmentService.deleteById(theId);

        return "redirect:/department/overview";
    }

}
