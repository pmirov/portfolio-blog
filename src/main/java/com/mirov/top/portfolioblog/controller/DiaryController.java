package com.mirov.top.portfolioblog.controller;


import com.mirov.top.portfolioblog.entity.DiaryEntry;
import com.mirov.top.portfolioblog.entity.Project;
import com.mirov.top.portfolioblog.repository.DiaryEntryRepository;
import com.mirov.top.portfolioblog.repository.ProjectRepository;
import com.mirov.top.portfolioblog.service.DiaryEntryService;
import com.mirov.top.portfolioblog.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
public class DiaryController {

    private DiaryEntryService diaryEntryService;
    private final DiaryEntryRepository diaryEntryRepository;

    public DiaryController(DiaryEntryService diaryEntryService, DiaryEntryRepository diaryEntryRepository) {
        this.diaryEntryService = diaryEntryService;
        this.diaryEntryRepository = diaryEntryRepository;
    }

    @GetMapping("/diary")
    public String diary(Model model) {
        model.addAttribute("diary", diaryEntryService.findAll());
        return "diary/all-items";
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("diary", diaryEntryService.findAll());
        return "index";
    }

    @GetMapping("/diary/{id}")
    public String info(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("diary",diaryEntryService.findById(id));
        return "diary/fullarticle";
    }

    @GetMapping("/diary/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
       DiaryEntry diaryEntry = diaryEntryService.findById(id);
        model.addAttribute("diaryEntry",diaryEntry);
//        model.addAttribute("project",projectService.findById(id));
        return "diary/editentry";

    }

    @PostMapping("/diary/edit")
    public String edit(@RequestParam Integer id, @ModelAttribute("project") DiaryEntry diaryEntry, Model model)
    {

        DiaryEntry existDiaryEntry = diaryEntryService.findById(id);

        existDiaryEntry.
        existProject.setTitle(project.getTitle());
        existProject.setDescription(project.getDescription());
        existProject.setGithubUrl(project.getGithubUrl());
        existProject.setPublic(project.isPublic());
        existProject.setUpdatedAt(LocalDateTime.now());
        projectService.update(existProject);
        return "redirect:/project/"+existProject.getId();
    }
}
