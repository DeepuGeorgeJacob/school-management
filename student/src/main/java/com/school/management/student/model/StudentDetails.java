package com.school.management.student.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity
@NoArgsConstructor
@Data
@JsonIgnoreProperties(value = "hibernateLazyInitializer")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer age;
    private String dateOfBirth;
    private String contactNumber;

    @JsonBackReference
    @OneToOne(mappedBy = "studentDetails")
    private Student student;

}
