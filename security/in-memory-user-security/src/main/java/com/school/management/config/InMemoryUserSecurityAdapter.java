package com.school.management.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UserDetailsRepositoryReactiveAuthenticationManager;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.server.SecurityWebFilterChain;

// https://www.linkedin.com/pulse/spring-microservices-security-best-practices-abid-anjum/?trk=pulse-article_more-articles_related-content-card
// https://www.baeldung.com/spring-security-5-reactive
// https://docs.spring.io/spring-security/site/docs/5.2.1.RELEASE/reference/htmlsingle/#webflux-oauth2-resource-server
@Configuration
public class InMemoryUserSecurityAdapter {

    @Bean
    public SecurityWebFilterChain filterChain(ServerHttpSecurity http) {
        return http
                .authorizeExchange()
                .pathMatchers("/school-library-service/**").authenticated()
                .and().authenticationManager(reactiveAuthenticationManager())
                .authorizeExchange().anyExchange().permitAll().and()
                .httpBasic().and()
                .build();
    }

    @Bean
    ReactiveAuthenticationManager reactiveAuthenticationManager(){
        return new UserDetailsRepositoryReactiveAuthenticationManager(getInMemoryUserDetails());
    }

    @Bean
    public MapReactiveUserDetailsService getInMemoryUserDetails() {
        UserDetails admin = User.withDefaultPasswordEncoder().username("admin1").password("password")
                .roles("ADMIN")
                .build();
        return new MapReactiveUserDetailsService(admin);
    }
}
