package com.school.management.repo;

import com.school.management.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Demo, Long> {

    @Query(value = "SELECT first_name as firstName, last_name as lastName,email FROM CUSTOMER", nativeQuery = true)
    List<Customer> getCustomers();

}
