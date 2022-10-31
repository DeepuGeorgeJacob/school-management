package com.school.management.library.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "student_membership")
@Data
public class Membership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "membership_number")
    private int membershipNumber;

    @Column(name = "student_id")
    private int studentId;

    @Column(name = "created_date")
    private Date createdDate;

}
