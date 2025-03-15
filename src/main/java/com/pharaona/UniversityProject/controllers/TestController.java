package com.pharaona.UniversityProject.controllers;

import com.pharaona.UniversityProject.models.QuestionGroup;
import com.pharaona.UniversityProject.models.Test;
import com.pharaona.UniversityProject.services.test.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    private TestService testService;

    public TestController(TestService theTestService) {
        testService = theTestService;
    }

    @GetMapping("/overview")
    public String listOfTests() {
        List<Test> tests = testService.findAll();

        return "";
    }

    @GetMapping("/add")
    public String showAddForm(Model theModel) {
        Test theTest = new Test();
        theModel.addAttribute("test", theTest);

        return "";
    }

    @PostMapping("/save")
    public String save(@RequestBody Test theTest) {
        testService.save(theTest);

        return "";
    }


    @GetMapping("/generateTest")
    public String save(@RequestParam ("testId") int testId,@RequestParam ("studentId") int studentId) {
        testService.generateTest(testId,studentId);

        return "";
    }

    @GetMapping("/update")
    public String update(@RequestParam ("testId") int testId, Model theModel) {
        Test theTest = testService.findById(testId);
        theModel.addAttribute("test", theTest);

        return "";
    }

    //request param reads from http body
    @GetMapping("/delete")
    public String delete(@RequestParam("testId") int theId) {
        testService.deleteById(theId);

        return "";
    }

    @GetMapping("/details")
    public String details(@RequestParam("testId") int theId, Model theModel) {
        Test theTest = testService.findById(theId);
        theModel.addAttribute("test", theTest);

        return "";
    }


}
