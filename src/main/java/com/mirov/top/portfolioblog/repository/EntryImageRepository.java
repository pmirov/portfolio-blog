package com.mirov.top.portfolioblog.repository;

import com.mirov.top.portfolioblog.entity.EntryImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EntryImageRepository extends JpaRepository<EntryImage, Integer> {
    List<EntryImage> findByDiaryEntryId(Integer entryId);
}
