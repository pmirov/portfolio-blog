package com.mirov.top.portfolioblog.service;

import com.mirov.top.portfolioblog.entity.Project;
import com.mirov.top.portfolioblog.repository.ProjectRepository;
import com.mirov.top.portfolioblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository, UserRepository userRepository)
    {
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
    }

    public List<Project> findAllByUserId(Integer userId)
    {
        return projectRepository.findByUserId(userId);
    }

    public List<Project> findAllPublic()
    {
        return projectRepository.findByIsPublicTrue();
    }



}
