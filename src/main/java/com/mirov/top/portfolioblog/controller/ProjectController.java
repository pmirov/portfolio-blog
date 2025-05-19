package com.mirov.top.portfolioblog.controller;

import com.mirov.top.portfolioblog.entity.Project;
import com.mirov.top.portfolioblog.repository.ProjectRepository;
import com.mirov.top.portfolioblog.service.ProjectService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
public class ProjectController {
    private ProjectService projectService;
    private final ProjectRepository projectRepository;

    public ProjectController(ProjectService projectService, ProjectRepository projectRepository) {
        this.projectService = projectService;
        this.projectRepository = projectRepository;
    }

    @GetMapping("/project")
    public String project(Model model) {
        model.addAttribute("projects", projectService.findAll());
        return "project/allprojects";
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("projects", projectService.findAll());
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

//    @GetMapping("/project/delete/{id}")
//    public String delete(@PathVariable Integer id, Model model) {
//        projectService.delete(id);
//        return "redirect:/project";
//    }



    public void update(Project project) {
        projectRepository.save(project);
    }


}
