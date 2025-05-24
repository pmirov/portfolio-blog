package com.mirov.top.portfolioblog.controller;


import com.mirov.top.portfolioblog.entity.DiaryEntry;
import com.mirov.top.portfolioblog.entity.Project;
import com.mirov.top.portfolioblog.entity.User;
import com.mirov.top.portfolioblog.repository.DiaryEntryRepository;
import com.mirov.top.portfolioblog.repository.EntryImageRepository;
import com.mirov.top.portfolioblog.repository.ProjectRepository;
import com.mirov.top.portfolioblog.repository.UserRepository;
import com.mirov.top.portfolioblog.service.DiaryEntryService;
import com.mirov.top.portfolioblog.service.ProjectService;
import com.mirov.top.portfolioblog.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import com.mirov.top.portfolioblog.entity.EntryImage;



import java.time.LocalDateTime;

@Controller
public class DiaryController {

    private DiaryEntryService diaryEntryService;
    private final DiaryEntryRepository diaryEntryRepository;
    private final UserService userService;


    public DiaryController(DiaryEntryService diaryEntryService, DiaryEntryRepository diaryEntryRepository,
    UserService userService) {
        this.diaryEntryService = diaryEntryService;
        this.diaryEntryRepository = diaryEntryRepository;
        this.userService = userService;

    }

    @GetMapping("/diary")
    public String showAllItems(Model model) {
        model.addAttribute("allitems", diaryEntryService.findAll());
        return "diary/allitems";
    }


    @GetMapping("/diary/{id}")
    public String diaryInfo(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("diaryEntry", diaryEntryService.findById(id));
        return "diary/iteminfo";
    }

    @GetMapping("/diary/edit/{id}")
    public String diaryEdit(@PathVariable("id") Integer id, Model model) {
        DiaryEntry diaryEntry = diaryEntryService.findById(id);
        model.addAttribute("diaryEntry", diaryEntry);
//        model.addAttribute("project",projectService.findById(id));
        return "diary/edititem";

    }

    @PostMapping("/diary/edit")
    public String diaryEdit(@RequestParam Integer id, @ModelAttribute("diaryEntry") DiaryEntry diaryEntry, Model model) {

        DiaryEntry existDiaryEntry = diaryEntryService.findById(id);

        existDiaryEntry.setTitle(diaryEntry.getTitle());
        existDiaryEntry.setContent(diaryEntry.getContent());
        existDiaryEntry.setPublic(diaryEntry.isPublic());
        existDiaryEntry.setUpdatedAt(LocalDateTime.now());
        diaryEntryService.update(existDiaryEntry);
        return "redirect:/diary/" + existDiaryEntry.getId();
    }

    @GetMapping("/diary/delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        diaryEntryService.delete(id);
        return "redirect:/diary";
    }

    @GetMapping("/diary/new")
    public String showCreateForm(Model model) {
        model.addAttribute("diaryEntry", new DiaryEntry());
        return "diary/new";
    }


    @PostMapping("/diary/new")
    public String createDiaryItem(@ModelAttribute("diaryEntry") DiaryEntry diaryEntry, Model model)
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();
        User user = userService.findByUsername(currentUsername);
        diaryEntry.setUser(user);

//        User user = userService.findById(1);
//        diaryEntry.setUser(user);
        LocalDateTime now = LocalDateTime.now();
        diaryEntry.setTitle(diaryEntry.getTitle());
        diaryEntry.setContent(diaryEntry.getContent());
        diaryEntry.setCreatedAt(now);
        diaryEntry.setUpdatedAt(now);
        diaryEntry.setPublic(true);
        diaryEntry.setUser(diaryEntry.getUser());

        DiaryEntry createdEntry = diaryEntryService.create(diaryEntry);

        return "redirect:/diary/" + createdEntry.getId();
    }
}
