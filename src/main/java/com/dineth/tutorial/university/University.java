package com.dineth.tutorial.university;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity @Table @Getter @Setter @NoArgsConstructor
public class University implements Serializable {
    @Id
    @SequenceGenerator(name="university_sequence",sequenceName = "university_sequence",allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "university_sequence"
    )
    private Long id;
    private String name;
    private String country;
    private String alpha_two_code;
    private String state_province;
    @ElementCollection
    private List<String> domains;
    @ElementCollection
    private List<String> web_pages;

    public University(String name, String country, String alpha_two_code, String state_province, List<String> domains, List<String> web_pages) {
        this.name = name;
        this.country = country;
        this.alpha_two_code = alpha_two_code;
        this.state_province = state_province;
        this.domains = domains;
        this.web_pages = web_pages;
    }

    @Override
    public String toString() {
        return "University{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", alpha_two_code='" + alpha_two_code + '\'' +
                ", state_province='" + state_province + '\'' +
                ", domains=" + domains +
                ", web_pages=" + web_pages +
                '}';
    }
}
