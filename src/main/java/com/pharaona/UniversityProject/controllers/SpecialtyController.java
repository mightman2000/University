package com.pharaona.UniversityProject.controllers;

import com.pharaona.UniversityProject.models.Department;
import com.pharaona.UniversityProject.models.Faculty;
import com.pharaona.UniversityProject.models.Speciality;
import com.pharaona.UniversityProject.services.department.DepartmentService;
import com.pharaona.UniversityProject.services.specialty.SpecialtyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/specialty")
public class SpecialtyController {

    private SpecialtyService specialtyService;
    private DepartmentService departmentService;

    public SpecialtyController(SpecialtyService theSpecialtyService, DepartmentService theDepartmentService) {
        specialtyService = theSpecialtyService;
        departmentService = theDepartmentService;
    }

    @GetMapping("/overview")
    public String listOfSpecialties(Model theModel){

        List<Speciality> specialities = specialtyService.findAll();
        theModel.addAttribute("specialty",specialities);

        return "specialty/overview";
    }

    @GetMapping("/add")
    public String showAddForm(Model theModel){

        Speciality theSpecialty = new Speciality();
        theModel.addAttribute("specialty", theSpecialty);

        // Fetch the list of departments
        List<Department> theDepartment = departmentService.findAll();
        theModel.addAttribute("department", theDepartment);

        return "specialty/add-form";
    }

    @PostMapping("/save")
    public String save (@ModelAttribute("specialty")Speciality theSpecialty, @RequestParam("department") int departmentId){

        Department selectedDepartment = departmentService.findById(departmentId);

        theSpecialty.setDepartment(selectedDepartment);

        specialtyService.save(theSpecialty);

        return "redirect:/specialty/overview";
    }

    @GetMapping("/update")
    public String update(@RequestParam("specialtyId") int theId, Model theModel){

        Speciality theSpeciality = specialtyService.findById(theId);
        theModel.addAttribute("specialty", theSpeciality);

        //fetch all departments to fill and display the dropdown
        List<Department> theDepartment = departmentService.findAll();
        theModel.addAttribute("department", theDepartment);

        return "/specialty/add-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam ("specialtyId") int theId){
        specialtyService.deleteById(theId);

        return "redirect:/specialty/overview";

    }
}
