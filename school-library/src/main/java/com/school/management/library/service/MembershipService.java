package com.school.management.library.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.school.management.common.exception.handler.DataNotFoundException;
import com.school.management.common.exception.handler.DataPresentException;
import com.school.management.common.response.ApiResponse;
import com.school.management.library.dto.MembershipDto;
import com.school.management.library.model.Membership;
import com.school.management.library.repository.MembershipRepository;
import com.school.management.library.request.MembershipRequest;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.Map;
import java.util.Objects;

@Service
public class MembershipService {

    private static final Logger log = LoggerFactory.getLogger(MembershipService.class);

    @Autowired
    private MembershipRepository membershipRepository;

    @Autowired
    private WebClient webClient;

    @Autowired
    private StudentService studentService;

    public ResponseEntity<ApiResponse<MembershipDto>> createMembership(final MembershipRequest membershipRequest) {
        var presentMemberShip = membershipRepository.findByStudentId(membershipRequest.getStudentId());
        if (presentMemberShip == null) {
            final Membership membership = new Membership();
            membership.setStudentId(membershipRequest.getStudentId());
            membership.setCreatedDate(new Date());
            final Membership saveData = membershipRepository.save(membership);
            final MembershipDto membershipDto = new MembershipDto(
                    saveData.getMembershipNumber(),
                    saveData.getStudentId(),
                    saveData.getCreatedDate(),
                    getStudentDetails(membershipRequest.getStudentId())
            );
            return ResponseEntity.ok(
                    ApiResponse.<MembershipDto>builder().data(membershipDto).build()
            );
        } else {
            throw new DataPresentException("Membership available");
        }

    }

    public ResponseEntity<ApiResponse<MembershipDto>> getLibraryMembershipWebClient(int id) {
        var presentMemberShip = membershipRepository.findByStudentId(id);
        if (presentMemberShip != null) {
            MembershipDto membershipDto = new MembershipDto(
                    presentMemberShip.getMembershipNumber(),
                    presentMemberShip.getStudentId(),
                    presentMemberShip.getCreatedDate(),
                    getStudentDetails(id)
            );
            var response = ApiResponse.<MembershipDto>builder().data(membershipDto).build();
            return ResponseEntity.ok(response);
        } else {
            throw new DataNotFoundException("Student has no membership");
        }

    }

    public ResponseEntity<ApiResponse<MembershipDto>> getLibraryMembershipFeign(HttpServletRequest request, int id) {
        var presentMemberShip = membershipRepository.findByStudentId(id);
        if (presentMemberShip != null) {
            var studentDetails = studentService.getStudentById(getHeaders(request), id);
            MembershipDto membershipDto = new MembershipDto(
                    presentMemberShip.getMembershipNumber(),
                    presentMemberShip.getStudentId(),
                    presentMemberShip.getCreatedDate(),
                    studentDetails
            );
            var response = ApiResponse.<MembershipDto>builder().data(membershipDto).build();
            return ResponseEntity.ok(response);
        } else {
            throw new DataNotFoundException("Student has no membership");
        }

    }

    private Object getStudentDetails(final int studentId) {
        final Mono<ResponseEntity<Map>> responseEntity = webClient.get().uri("api/students/" + studentId).retrieve().toEntity(Map.class);
        final ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(Objects.requireNonNull(Objects.requireNonNull(responseEntity.block()).getBody()).get("data"), Object.class);
    }

    private HttpHeaders getHeaders(final HttpServletRequest httpServletRequest) {
        var iterator = httpServletRequest.getHeaderNames().asIterator();
        final HttpHeaders headers = new HttpHeaders();
        while (iterator.hasNext()) {
            var key = iterator.next();
            headers.add(key, httpServletRequest.getHeader(key));
        }
        return headers;
    }
}
