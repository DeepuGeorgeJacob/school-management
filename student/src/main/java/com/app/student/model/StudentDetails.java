package com.app.student.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@JsonIgnoreProperties(value = "hibernateLazyInitializer")
public class StudentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int age;
    private String dateOfBirth;
    private String contactNumber;

    @JsonBackReference
    @OneToOne(mappedBy = "studentDetails")
    private Student student;

}
