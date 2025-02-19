package com.pharaona.UniversityProject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(Customizer.withDefaults()) // CSRF protection enabled (default)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login", "/logout", "/error", "/home", "/").permitAll()
                        .requestMatchers("/static/**", "/images/**", "/css/**", "/js/**").permitAll() // Explicitly allow static files
                        .requestMatchers("/faculty/upload-json").hasRole("ADMIN")
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED) // Session only when needed
                        .maximumSessions(1) // Prevent multiple active sessions per user
                )
                .formLogin(form -> form
                        .usernameParameter("email") // Email instead of username
                        .defaultSuccessUrl("/home", true)
                        .permitAll()
                )
                .logout(config -> config
                        .logoutUrl("/logout") // Requires POST request
                        .logoutSuccessUrl("/home")
                        .invalidateHttpSession(true) // Destroy session
                        .deleteCookies("JSESSIONID") // Full logout
                )
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}




