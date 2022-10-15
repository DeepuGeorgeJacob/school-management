package com.school.maganement.library.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MembershipDto {

    private int membershipNumber;

    private int studentId;

    private Date createdDate;

    private Object student;

}
