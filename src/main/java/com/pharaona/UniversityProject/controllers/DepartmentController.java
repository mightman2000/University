package com.pharaona.UniversityProject.controllers;

import com.pharaona.UniversityProject.models.Department;
import com.pharaona.UniversityProject.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    DepartmentService departmentService;

    @Autowired
    public DepartmentController (DepartmentService theDepartmentService){
        departmentService = theDepartmentService;
    }

    @GetMapping("/overview")
    public String listOfDepartments (Model theModel){

        List<Department> theDepartment = departmentService.findAll();

        theModel.addAttribute("departments", theDepartment);

        return "/department/overview";
    }




}
