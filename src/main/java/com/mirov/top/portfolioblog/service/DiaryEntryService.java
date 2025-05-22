package com.mirov.top.portfolioblog.service;

import com.mirov.top.portfolioblog.entity.DiaryEntry;
import com.mirov.top.portfolioblog.entity.Project;
import com.mirov.top.portfolioblog.repository.DiaryEntryRepository;
import com.mirov.top.portfolioblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    public DiaryEntry findById(Integer id)
    {
        return diaryEntryRepository.findById(id).orElseThrow();
    }


    public List<DiaryEntry> findAll()
    {
        List<DiaryEntry> all = diaryEntryRepository.findAll();
        //System.out.println("findall = " + all);
        return all;
    }

    public void update(DiaryEntry diaryEntry) {
        diaryEntryRepository.save(diaryEntry);
    }

    public void delete(Integer id) {
        diaryEntryRepository.deleteById(id);
    }

    public DiaryEntry create(DiaryEntry diaryEntry) {
        LocalDateTime now = LocalDateTime.now();
        diaryEntry.getCreatedAt();
        diaryEntry.getUpdatedAt();
        return diaryEntryRepository.save(diaryEntry);
    }
}
