package com.pharaona.UniversityProject.controllers;

import com.pharaona.UniversityProject.models.Faculty;
import com.pharaona.UniversityProject.services.faculty.FacultyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/faculty")
public class FacultyController {

    private FacultyService facultyService;

    public FacultyController (FacultyService facultyService){
        this.facultyService = facultyService;
    }

  // //return all
  // @GetMapping("/list")
  // public List<Faculty> listFaculty(){

  //     return facultyService.findAll();
  // }

  // //return by id
  // @GetMapping("/{id}")
  // public Faculty getFacultyById(@PathVariable int id) {
  //     return facultyService.findById(id);
  // }

    //
    @GetMapping("/overview")
    public String listOfFaculties(Model theModel){

        List<Faculty> theFaculties = facultyService.findAll();

        theModel.addAttribute("faculty", theFaculties);
        return "faculty/overview";
    }

    @GetMapping("/add")
    public String showAddForm(Model theModel){

        Faculty theFaculty = new Faculty();
        theModel.addAttribute("faculty", theFaculty);
        return "/faculty/add-form";

    }

    @PostMapping("/save")
    public String save(@ModelAttribute ("faculty") Faculty theFaculty){

        facultyService.save(theFaculty);

        return "redirect:/faculty/overview";
    }

    @GetMapping("/update")
    public String update (@RequestParam ("facultyId") int theId, Model theModel){

        Faculty theFaculty = facultyService.findById(theId);
        theModel.addAttribute("faculty", theFaculty);

        return "faculty/add-form";
    }

    @GetMapping("/delete")
    public String delete (@RequestParam("facultyId") int theId){

        facultyService.deleteById(theId);

        return "redirect:/faculty/overview";
    }

}
