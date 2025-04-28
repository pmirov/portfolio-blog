package com.mirov.top.portfolioblog.repository;

import com.mirov.top.portfolioblog.entity.DiaryEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DiaryEntryRepository extends JpaRepository<DiaryEntry, Integer> {
    List<DiaryEntry> findByUserId(Integer userId);
    List<DiaryEntry> findByIsPublicTrue();
    Optional<DiaryEntry> findByIdAndUserId(Integer Id, Integer userId);



}
