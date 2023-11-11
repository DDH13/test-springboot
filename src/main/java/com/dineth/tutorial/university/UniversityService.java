package com.dineth.tutorial.university;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityService {
    private final UniversityRepository universityRepository;

    public UniversityService(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    public List<University> getUniversities() {
        return universityRepository.findAll();
    }
    public void addNewUniversity(University university) {
        universityRepository.save(university);
        System.out.println(university);
    }

    public void deleteUniversity(Long universityId) {
        boolean exists = universityRepository.existsById(universityId);
        if (!exists) {
            throw new IllegalStateException("university with id " + universityId + " does not exists");
        }
        universityRepository.deleteById(universityId);
    }
}
