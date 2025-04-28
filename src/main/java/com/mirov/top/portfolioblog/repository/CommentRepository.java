package com.mirov.top.portfolioblog.repository;

import com.mirov.top.portfolioblog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    List<Comment> findByDiaryEntryId(Integer entryId);
    List<Comment> findByUserId(Integer userId);
}
