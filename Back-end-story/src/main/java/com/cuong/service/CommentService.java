package com.cuong.service;

import com.cuong.model.Comment;

public interface CommentService {
    void save(Comment comment);

    Comment findCommentById(Long id);
}
