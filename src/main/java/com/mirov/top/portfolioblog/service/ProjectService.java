package com.mirov.top.portfolioblog.service;

import com.mirov.top.portfolioblog.entity.DiaryEntry;
import com.mirov.top.portfolioblog.entity.Project;
import com.mirov.top.portfolioblog.repository.ProjectRepository;
import com.mirov.top.portfolioblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    public Project findById(Integer id)
    {
        return projectRepository.findById(id).orElseThrow();
    }

    public List<Project> findAll()
    {
        List<Project> all = projectRepository.findAll();
        System.out.println("findall = " + all);
        return all;
    }

    public void update(Project project) {
        projectRepository.save(project);
    }

    public void delete(Integer id) {
        projectRepository.deleteById(id);
    }

    public Project create(Project project) {
        LocalDateTime now = LocalDateTime.now();
        project.getCreatedAt();
        project.getUpdatedAt();
        return projectRepository.save(project);
    }
//    public List<Project> findAllPublic()
//    {
//        return projectRepository.findByIsPublicTrue();
//    }
//    public List<Project> findAllByUserId(Integer userId)
//    {
//        return projectRepository.findByUserId(userId);
//    }


}
