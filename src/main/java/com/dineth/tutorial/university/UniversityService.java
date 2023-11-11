package com.dineth.tutorial.university;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UniversityService {
    private final UniversityRepository universityRepository;
    private final RestTemplate restTemplate;

    public UniversityService(UniversityRepository universityRepository, RestTemplateBuilder restTemplateBuilder) {
        this.universityRepository = universityRepository;
        this.restTemplate = restTemplateBuilder.build();
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

    public void getUniversityFromAPI(String country) {
        try {
            University[] universities = this.restTemplate.getForObject("http://universities.hipolabs.com/search?country={country}", University[].class, country);
            if (universities != null) {
                for (University university : universities) {
                    this.addNewUniversity(university);
                }
            } else {
                System.out.println("No universities found");
            }
        } catch (RestClientException e) {
            System.out.println("Error fetching universities: " + e.getMessage());
        }
    }


}