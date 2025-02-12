package com.pharaona.UniversityProject.controllers;

import com.pharaona.UniversityProject.models.Curriculum;
import com.pharaona.UniversityProject.models.junction.DisciplineCurriculum;
import com.pharaona.UniversityProject.services.curriculum.CurriculumService;
import com.pharaona.UniversityProject.services.discipline_curriculum.DisciplineCurriculumService;
import jakarta.persistence.Entity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/curriculum")
public class CurriculumController {

    private CurriculumService curriculumService;
    private DisciplineCurriculumService disciplineCurriculumService;

    public CurriculumController(CurriculumService theCurriculumService, DisciplineCurriculumService theDisciplineCurriculumService) {
        curriculumService = theCurriculumService;
        disciplineCurriculumService = theDisciplineCurriculumService;
    }


    @GetMapping("/overview")
    public String listOfCurricula(Model theModel) {

        List<Curriculum> curricula = curriculumService.findAllWithDisciplines();
        theModel.addAttribute("curricula", curricula);

        return "curriculum/overview";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("curriculumId") int theId) {

        curriculumService.deleteById(theId);

        return "redirect:/curriculum/overview";

    }

}
