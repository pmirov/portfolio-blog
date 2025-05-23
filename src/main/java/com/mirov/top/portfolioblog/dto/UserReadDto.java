package com.mirov.top.portfolioblog.dto;

import com.mirov.top.portfolioblog.entity.Role;
import lombok.Value;

import java.time.LocalDate;

@Value
public class UserReadDto {

    Long id;
    String username;
    String email;
    Role role;
    String profileImageUrl;

}
