package com.pharaona.UniversityProject.controllers;

import com.pharaona.UniversityProject.models.Faculty;
import com.pharaona.UniversityProject.services.faculty.FacultyService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.security.Principal;
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
    public String save(@Valid @ModelAttribute("faculty") Faculty theFaculty, BindingResult result) {
        // Check if the email is unique
        if (!facultyService.isEmailUnique(theFaculty.getEmail())) {
            result.rejectValue("email", "error.email", "Email is already in use");
        }

        if (result.hasErrors()) {
            return "/faculty/add-form";  // Return to the form if there are errors
        }

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

    @PostMapping("/upload-json")
    public ResponseEntity<String> uploadFaculty(@RequestBody List<Faculty> facultyList){

        facultyService.saveAllFaculties(facultyList);
        return ResponseEntity.ok("Faculty data uploaded successfully.");
    }

}
