package com.school.management.service;

import com.school.management.repository.ApplicationUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
// References
// https://www.youtube.com/watch?v=bL23Xbyqc7s&t=78s
// https://www.youtube.com/watch?v=GaMPjiqNKL8
@Service
public class UserDetailsService implements ReactiveUserDetailsService {

    final ApplicationUserRepository applicationUserRepository;

    @Autowired
    public UserDetailsService(ApplicationUserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }


    @Override
    public Mono<UserDetails> findByUsername(String username) {
        return applicationUserRepository.findUsername(username).cast(UserDetails.class);
    }
}
