package com.mirov.top.portfolioblog.controller;

import com.mirov.top.portfolioblog.entity.DiaryEntry;
import com.mirov.top.portfolioblog.entity.Project;
import com.mirov.top.portfolioblog.entity.User;
import com.mirov.top.portfolioblog.repository.ProjectRepository;
import com.mirov.top.portfolioblog.service.DiaryEntryService;
import com.mirov.top.portfolioblog.service.ProjectService;
import com.mirov.top.portfolioblog.service.UserService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Scanner;

@Controller
public class ProjectController {
    private ProjectService projectService;
    private DiaryEntryService diaryEntryService;
    private final ProjectRepository projectRepository;
    private final UserService userService;

    public ProjectController(DiaryEntryService diaryEntryService, ProjectService projectService,
                             ProjectRepository projectRepository, UserService userService) {
        this.projectService = projectService;
        this.diaryEntryService = diaryEntryService;
        this.projectRepository = projectRepository;
        this.userService = userService;
    }

    @GetMapping("/project")
    public String project(Model model) {
        model.addAttribute("projects", projectService.findAll());
        return "project/allprojects";
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("diaryEntry", diaryEntryService.findAll());
        return "index";
    }

    @GetMapping("/project/{id}")
    public String info(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("project",projectService.findById(id));
        return "project/projectinfo";
    }

    @GetMapping("/project/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        Project project = projectService.findById(id);
        model.addAttribute("project",project);
//        model.addAttribute("project",projectService.findById(id));
        return "project/editproject";

    }

    @PostMapping("/project/edit")
    public String edit(@RequestParam Integer id, @ModelAttribute("project") Project project, Model model)
    {

        Project existProject = projectService.findById(id);

        existProject.setTitle(project.getTitle());
        existProject.setDescription(project.getDescription());
        existProject.setGithubUrl(project.getGithubUrl());
        existProject.setPublic(project.isPublic());
        existProject.setUpdatedAt(LocalDateTime.now());
        projectService.update(existProject);
        return "redirect:/project/"+existProject.getId();
    }

    @GetMapping("/project/newproject")
    public String showCreateForm(Model model) {
        model.addAttribute("project", new Project());
        return "project/newproject";
    }

    @PostMapping("/project/newproject")
    public String createProject(@ModelAttribute("project") Project project, Model model) {
        User user = userService.findById(1);
        project.setUser(user);
        LocalDateTime now = LocalDateTime.now();
        project.setTitle(project.getTitle());
        project.setDescription(project.getDescription());
        project.setCreatedAt(now);
        project.setUpdatedAt(now);
        Project createdProject = projectService.create(project);
        return "redirect:/project/"+createdProject.getId();
    }


    @GetMapping("/project/delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        projectService.delete(id);
        return "redirect:/project";
    }



    public void update(Project project) {
        projectRepository.save(project);
    }


}
