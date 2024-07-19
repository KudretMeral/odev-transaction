package com.vehicle.microservice_transaction.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Value("${service.security.secure-key-username}")
    private String SECURE_KEY_USERNAME;

    @Value("${service.security.secure-key-password}")
    private String SECURE_KEY_PASSWORD;
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user1 = User.builder()
                .username(SECURE_KEY_USERNAME)
                .password(bCryptPasswordEncoder().encode(SECURE_KEY_PASSWORD))
                .authorities("ROLE_USER")
                .build();


        return new InMemoryUserDetailsManager(user1);
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests((authentication) ->
                authentication.requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()
                        .anyRequest().authenticated()
        );
        http.httpBasic(httpBasic -> httpBasic.authenticationEntryPoint(new AuthEntryPoint()));
        http.csrf(csrf -> csrf.disable());
        http.headers(headers -> headers
                .frameOptions(frameOptions -> frameOptions
                        .disable()
                )
        );

        return http.build();
    }
}
