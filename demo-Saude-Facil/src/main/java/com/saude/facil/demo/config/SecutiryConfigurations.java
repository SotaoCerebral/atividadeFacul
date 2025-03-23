package com.saude.facil.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecutiryConfigurations {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {


        return http.csrf( csrf -> csrf.disable()).cors(cors -> {})
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).authorizeHttpRequests(
                        authorize -> authorize
                                .requestMatchers(HttpMethod.POST,"/login").permitAll()
                                .requestMatchers(HttpMethod.POST,"/usuarios").permitAll()
                                .requestMatchers(HttpMethod.POST,"/pacientes").permitAll()
                                .requestMatchers(HttpMethod.GET,"/pacientes").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.GET,"/pacientes/{id}").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT,"/pacientes/{id}").hasRole("COMUM")
                                .requestMatchers(HttpMethod.POST,"/horarios-disponiveis").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT,"/horarios-disponiveis/{id}").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE,"/horarios-disponiveis/{id}").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.POST,"/medicos").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT,"/medicos/{id}").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE,"/medicos/{id}").hasRole("ADMIN")
                                .anyRequest().authenticated()
                ).httpBasic(httpBasic -> {})
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return  configuration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }
}
