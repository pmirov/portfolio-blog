package com.mirov.top.portfolioblog.repository;

import com.mirov.top.portfolioblog.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, Integer>
{
    List<Project> findByUserId(Integer userId);
    List<Project> findByIsPublicTrue();
    Optional<Project> findByIdAndUserId(Integer id, Integer userId);

}
