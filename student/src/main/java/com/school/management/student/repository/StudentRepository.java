package com.school.management.student.repository;

import com.school.management.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    /**
     * For performance optimization use entry graph
     *  @EntityGraph(attributePaths = {"studentDetails","performance","guardian"})
     *  List<Student> findAll();
     */

}
