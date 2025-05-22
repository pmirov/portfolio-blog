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
    public String showAllItems(Model model) {
        model.addAttribute("allitems", diaryEntryService.findAll());
        return "diary/allitems";
    }

//    @GetMapping("/")
//    public String gohome(Model model) {
//        model.addAttribute("diaryEntry", diaryEntryService.findAll());
//        return "index";
//    }

    @GetMapping("/diary/{id}")
    public String diaryInfo(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("diaryEntry",diaryEntryService.findById(id));
        return "diary/iteminfo";
    }

    @GetMapping("/diary/edit/{id}")
    public String diaryEdit(@PathVariable("id") Integer id, Model model) {
       DiaryEntry diaryEntry = diaryEntryService.findById(id);
        model.addAttribute("diaryEntry",diaryEntry);
//        model.addAttribute("project",projectService.findById(id));
        return "diary/edititem";

    }

    @PostMapping("/diary/edit")
    public String diaryEdit(@RequestParam Integer id, @ModelAttribute("diaryEntry") DiaryEntry diaryEntry, Model model)
    {

        DiaryEntry existDiaryEntry = diaryEntryService.findById(id);

        existDiaryEntry.setTitle(diaryEntry.getTitle());
        existDiaryEntry.setContent(diaryEntry.getContent());
        existDiaryEntry.setPublic(diaryEntry.isPublic());
        existDiaryEntry.setUpdatedAt(LocalDateTime.now());
        diaryEntryService.update(existDiaryEntry);
        return "redirect:/diary/"+existDiaryEntry.getId();
    }

    @GetMapping("/diary/delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        diaryEntryService.delete(id);
        return "redirect:/diary";
    }
}
