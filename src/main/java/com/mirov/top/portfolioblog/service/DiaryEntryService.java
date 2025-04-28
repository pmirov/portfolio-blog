package com.mirov.top.portfolioblog.service;

import com.mirov.top.portfolioblog.entity.DiaryEntry;
import com.mirov.top.portfolioblog.repository.DiaryEntryRepository;
import com.mirov.top.portfolioblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiaryEntryService {

    private final DiaryEntryRepository diaryEntryRepository;
    private final UserRepository userRepository;

    @Autowired
    public DiaryEntryService(DiaryEntryRepository diaryEntryRepository, UserRepository userRepository) {
        this.diaryEntryRepository = diaryEntryRepository;
        this.userRepository = userRepository;
    }

    public List<DiaryEntry> findAllByUserId(Integer userId) {
        return diaryEntryRepository.findByUserId(userId);
    }

    public List<DiaryEntry> findAllPublic() {
        return diaryEntryRepository.findByIsPublicTrue();
    }




}
