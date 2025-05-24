package com.mirov.top.portfolioblog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static com.mirov.top.portfolioblog.entity.Role.ADMIN;
import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                //.csrf(CsrfConfigurer::disable)
                .authorizeHttpRequests(auth -> auth

                        .requestMatchers("/","/users/login", "/login","/static/**",
                        "/users/registration", "/css/**", "/js/**", "/img/**", "/error").permitAll()
                        .requestMatchers("/admin/**", "/diary/new", "/project/newproject").hasAuthority(ADMIN.getAuthority())
                        .requestMatchers(antMatcher("/users/{\\d}/delete"), antMatcher("/diary/delete/{\\d}"),antMatcher("/project/delete/{\\d}")).hasAnyAuthority(ADMIN.getAuthority())
                        .anyRequest().authenticated())
                        .formLogin(login -> login
                                .loginPage("/users/login")
                                .loginProcessingUrl("/login")
                                .defaultSuccessUrl("/")
                                .permitAll())
                .logout(logout -> logout.logoutUrl("/logout")
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
                        .logoutSuccessUrl("/")
                        .deleteCookies("JSESSIONID"));
        return http.build();
    }



    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}

