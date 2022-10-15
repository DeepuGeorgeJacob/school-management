package com.school.maganement.library.service;

import com.common.exception.handler.DataNotFoundException;
import com.common.exception.handler.DataPresentException;
import com.common.response.ApiResponse;
import com.school.maganement.library.model.Membership;
import com.school.maganement.library.repository.MembershipRepository;
import com.school.maganement.library.request.MembershipRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MembershipService {
    @Autowired
    private MembershipRepository membershipRepository;

    public ResponseEntity<ApiResponse<Membership>> createMembership(final MembershipRequest membershipRequest) {
        var presentMemberShip = membershipRepository.findByStudentId(membershipRequest.getStudentId());
        if (presentMemberShip == null) {
            final Membership membership = new Membership();
            membership.setStudentId(membershipRequest.getStudentId());
            membership.setCreatedDate(new Date());
            final Membership saveData = membershipRepository.save(membership);
            return ResponseEntity.ok(
                    ApiResponse.<Membership>builder().data(saveData).build()
            );
        } else {
            throw new DataPresentException("Membership available");
        }

    }

    public ResponseEntity<ApiResponse<Membership>> getLibraryMembership(int id) {
        var presentMemberShip = membershipRepository.findByStudentId(id);
        if (presentMemberShip!=null) {
            var response = ApiResponse.<Membership>builder().data(presentMemberShip).build();
            return ResponseEntity.ok(response);
        } else {
            throw new DataNotFoundException("Student has no membership");
        }

    }
}
