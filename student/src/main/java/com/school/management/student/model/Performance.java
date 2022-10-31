package com.school.management.student.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@JsonIgnoreProperties(value = "hibernateLazyInitializer")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Performance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int bestPerformance;
    private int lastPerformance;

    @JsonBackReference
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;
}
