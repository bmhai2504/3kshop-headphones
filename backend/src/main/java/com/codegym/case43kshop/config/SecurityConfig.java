package com.codegym.case43kshop.config;


import com.codegym.case43kshop.security.JwtTokenFilters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@EnableAutoConfiguration
@EnableAsync
public class SecurityConfig {
    @Autowired
    private JwtTokenFilters jwtTokenFilters;

    @Bean
    public PasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().cors();

        http.authorizeHttpRequests()
                .antMatchers("/api/auth/**")
                .permitAll();

//        http.authorizeHttpRequests() // links start with /api/
//                .antMatchers("/api/auth/login") // perform segregate authorize
//                .permitAll();

        http.authorizeHttpRequests()
                .antMatchers("/api/category/**")
                .permitAll();

        http.authorizeHttpRequests()
                .antMatchers("/api/brand/**")
                .permitAll();

        http.authorizeHttpRequests()
                .antMatchers("/api/product/**")
                .permitAll();;



        http.authorizeHttpRequests()
                .antMatchers("/api/cart-item/**")
                .permitAll();

        http.authorizeHttpRequests()
                .antMatchers("/api/admin/**")
                        .hasAnyRole("ADMIN");

        // When user login with ROLE_USER, but try to
        // access pages require ROLE_ADMIN, redirect to /error-403
//        http.authorizeHttpRequests().and().exceptionHandling()
//                .accessDeniedPage("/api/auth/access-denied");

        // Configure remember me (save token in database)
        // Use JwtAuthorizationFilter to check token -> get user info
        http.addFilterBefore(jwtTokenFilters, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
