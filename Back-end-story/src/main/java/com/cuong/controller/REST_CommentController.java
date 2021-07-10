package com.cuong.controller;

import com.cuong.model.Blog;
import com.cuong.model.Comment;
import com.cuong.model.User;
import com.cuong.security.service.UserPrinciple;
import com.cuong.service.BlogService;
import com.cuong.service.CommentService;
import com.cuong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class REST_CommentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private BlogService blogService;

    @Autowired
    private UserService userService;

    @PostMapping("/api/comments/blogs/{idBlog}")
    public ResponseEntity<Void> createComment(@PathVariable("idBlog") Long idBlog,
                                              @RequestBody Comment comment) {
        List<Comment> commentList = new ArrayList<>();
        Blog blog = blogService.findById(idBlog);
        if( blog == null) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        comment.setBlog(blog);
        comment.setUser(getUserFromToken());
        commentList.add(comment);
        blog.setCommentList(commentList);
        commentService.save(comment);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }


    private User getUserFromToken() {
        Object authen = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long idUser = ((UserPrinciple)authen).getId();
        User user = userService.findUserByID(idUser);
        return user;
    }
}
