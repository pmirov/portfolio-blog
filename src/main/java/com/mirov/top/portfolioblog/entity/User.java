package com.mirov.top.portfolioblog.entity;

import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name="users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false, length = 100)
    private String password;

    @Enumerated(EnumType.STRING)
    @Builder.Default //непонятное место
    private Role role = Role.USER;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "telegram_id")
    private String telegramId;

    @Column(name = "profile_image_url")
    private String profileImageUrl;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL) //разобраться
    @Builder.Default
    private List<Project> projects = new ArrayList<>();


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL) //разобраться
    @Builder.Default
    private List<DiaryEntry> diaryEntries = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL) //разобраться
    @Builder.Default
    private List<Comment> comments = new ArrayList<>();


}
