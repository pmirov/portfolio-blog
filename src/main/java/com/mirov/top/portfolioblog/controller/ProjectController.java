package com.mirov.top.portfolioblog.controller;

import com.mirov.top.portfolioblog.repository.ProjectRepository;
import com.mirov.top.portfolioblog.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProjectController {
    private ProjectService projectService;
    private final ProjectRepository projectRepository;

    public ProjectController(ProjectService projectService, ProjectRepository projectRepository) {
        this.projectService = projectService;
        this.projectRepository = projectRepository;
    }

    @GetMapping("/project")
    public String diary(Model model) {
        model.addAttribute("projects", projectService.findAll());
        return "project/all";
    }

    @GetMapping("/project/{id}")
    public String info(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("project",projectService.findById(id));
        return "project/info";
    }

    @GetMapping("/project/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("project",projectService.findById(id));
        return "project/edit";
    }


}
