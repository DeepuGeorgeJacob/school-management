package com.school.maganement.library.repository;

import com.school.maganement.library.model.Membership;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembershipRepository extends JpaRepository<Membership,Integer> {

    Membership findByStudentId(int id);
}
