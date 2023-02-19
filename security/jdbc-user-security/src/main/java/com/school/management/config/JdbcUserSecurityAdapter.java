package com.school.management.config;

import com.school.management.service.UserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UserDetailsRepositoryReactiveAuthenticationManager;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

// https://www.tomaszezula.com/2022/01/22/spring-security-webflux-load-users-from-a-database/

@Configuration
@EnableWebFluxSecurity
public class JdbcUserSecurityAdapter {


    @Bean
    public SecurityWebFilterChain filterChain(ServerHttpSecurity http) {
        return http
                .csrf().disable().cors().disable()
                .authorizeExchange()
                .pathMatchers("/user-registration/**").permitAll()
                .pathMatchers("/student-service/**", "/school-library-service/**").authenticated()
                .and()
                .authorizeExchange().anyExchange().permitAll().and()
                .httpBasic().and()
                .build();
    }

    @Bean
    ReactiveAuthenticationManager reactiveAuthenticationManager(UserDetailsService userDetailsService) {
        var manager = new UserDetailsRepositoryReactiveAuthenticationManager(userDetailsService);
        manager.setPasswordEncoder(passwordEncoder());
        return manager;
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
        return new BCryptPasswordEncoder();
    }

}
