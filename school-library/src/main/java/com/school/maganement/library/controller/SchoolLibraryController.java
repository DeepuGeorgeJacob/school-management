package com.school.maganement.library.controller;

import com.common.response.ApiResponse;
import com.school.maganement.library.model.Membership;
import com.school.maganement.library.request.MembershipRequest;
import com.school.maganement.library.service.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/membership")
public class SchoolLibraryController {
    @Autowired
    private MembershipService membershipService;

    @PostMapping
    public ResponseEntity<ApiResponse<Membership>> createMembership(@RequestBody final MembershipRequest membershipRequest) {
       return membershipService.createMembership(membershipRequest);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<ApiResponse<Membership>>  getStudentMembership(@PathVariable int id) {
        return membershipService.getLibraryMembership(id);
    }

}
