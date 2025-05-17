package com.mirov.top.portfolioblog.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="projects")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Integer getId() {
        return id;
    }

    @ManyToOne(fetch = FetchType.LAZY) //разобраться
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @Column(nullable = false,length = 255)
    private String title;

    public String getTitle() {
        return title;
    }

    @Column
    private String description;

    public String getDescription() {
        return description;
    }

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "is_public")
    @Builder.Default
    private boolean isPublic = true;

    @Column(name = "github_url")
    private String githubUrl;


}
