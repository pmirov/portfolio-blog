package com.mirov.top.portfolioblog.service;

import com.mirov.top.portfolioblog.entity.Comment;
import com.mirov.top.portfolioblog.repository.CommentRepository;
import com.mirov.top.portfolioblog.repository.DiaryEntryRepository;
import com.mirov.top.portfolioblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService
{
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final DiaryEntryRepository diaryEntryRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, UserRepository userRepository, DiaryEntryRepository diaryEntryRepository)
    {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.diaryEntryRepository = diaryEntryRepository;
    }

    public List<Comment> findByDiaryEntryId(Integer entryId)
    {
        return commentRepository.findByDiaryEntryId(entryId);
    }

    
}
