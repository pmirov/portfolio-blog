package com.mirov.top.portfolioblog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(CsrfConfigurer::disable)
                .authorizeHttpRequests(auth -> auth.requestMatchers("/","/users/login", "/login",
                        "/users/registration", "/css/**", "/js/**", "/img/**").permitAll().anyRequest().authenticated())

                        .formLogin(login -> login
                                .loginPage("/users/login")
                                .loginProcessingUrl("/login")
                                .defaultSuccessUrl("/")
                                .permitAll())
                .logout(logout -> logout.logoutUrl("/logout")
                        .logoutSuccessUrl("/users/login")
                        .deleteCookies("JSESSIONID"));
        return http.build();
    }

//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf(CsrfConfigurer::disable)
//                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
//
//                .formLogin(login -> login
//                        .loginPage("/users/login")
//                        .loginProcessingUrl("/users/login")
//                        .defaultSuccessUrl("/")
//                        .permitAll())
//                .logout(logout -> logout.logoutUrl("/logout")
//                        .logoutSuccessUrl("/users/login")
//                        .deleteCookies("JSESSIONID"));
//        return http.build();
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
