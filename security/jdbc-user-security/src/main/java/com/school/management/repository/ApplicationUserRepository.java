package com.school.management.repository;

import com.school.management.entity.UsernamePasswordPrinciple;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Repository
@Transactional(readOnly = true)
public interface ApplicationUserRepository extends ReactiveCrudRepository<UsernamePasswordPrinciple,String> {

    @Query(value = "SELECT * FROM users WHERE LOWER(username) = LOWER(:username)")
    Mono<UsernamePasswordPrinciple> findUsername(String username);
}
