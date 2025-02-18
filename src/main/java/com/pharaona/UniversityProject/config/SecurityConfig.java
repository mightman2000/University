package com.pharaona.UniversityProject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
//                .csrf(csrf -> csrf.ignoringRequestMatchers("/login")) // Disable CSRF for login
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login", "/logout", "/error", "/home","/").permitAll()
                        .requestMatchers("/static/**", "/images/**").permitAll()
                        .requestMatchers("/faculty/upload-json").hasRole("ADMIN")
                        .requestMatchers("/admin/**").hasRole("ADMIN") // added gpt
                        //.requestMatchers("/teacher/**").hasAnyRole("TEACHER", "ADMIN") // added gpt
                        //.requestMatchers("/student/**").hasAnyRole("STUDENT", "TEACHER", "ADMIN") // added gpt
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .usernameParameter("email") // Look for email instead of username
                        .defaultSuccessUrl("/home", true)
                        .permitAll()
                )
                .logout(config -> config.logoutSuccessUrl("/home"))
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}




