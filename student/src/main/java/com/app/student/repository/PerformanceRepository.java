package com.app.student.repository;

import com.app.student.model.Performance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PerformanceRepository extends JpaRepository<Performance, Integer> {
    @Modifying
    @Query(value = "INSERT INTO performance (best_performance,last_performance,student_id) " +
            "VALUES (:bestPerformance, :lastPerformance, :studentId) ",
            nativeQuery = true)
    void insertPerformanceData(@Param("bestPerformance") final Integer bestPerformance,
                               @Param("lastPerformance") final Integer lastPerformance,
                               @Param("studentId") final Integer studentId);

}
