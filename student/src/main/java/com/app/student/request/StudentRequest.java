package com.app.student.request;

import lombok.Data;

import java.util.List;

@Data
public class StudentRequest {
    private Integer id;
    private List<Integer> courses;

}
