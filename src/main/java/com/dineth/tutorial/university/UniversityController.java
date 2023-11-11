package com.dineth.tutorial.university;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/university")
public class UniversityController {
    private UniversityService universityService;
    @Autowired
    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @GetMapping
    public List<University> getUniversities() {
        return universityService.getUniversities();
    }

    @PostMapping
    public void registerNewUniversity(@RequestBody  University university) {
        universityService.addNewUniversity(university);
    }

    @DeleteMapping(path = "{universityId}")
    public void deleteUniversity(@PathVariable("universityId") Long universityId) {
        universityService.deleteUniversity(universityId);
    }
}
