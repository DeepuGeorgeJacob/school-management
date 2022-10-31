package com.school.management.library.repository;

import com.school.management.library.model.Membership;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembershipRepository extends JpaRepository<Membership,Integer> {

    Membership findByStudentId(int id);
}
