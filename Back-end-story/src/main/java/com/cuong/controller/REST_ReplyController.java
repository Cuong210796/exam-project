package com.cuong.controller;

import com.cuong.model.Comment;
import com.cuong.model.Reply;
import com.cuong.model.User;
import com.cuong.security.service.UserPrinciple;
import com.cuong.service.CommentService;
import com.cuong.service.ReplyService;
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
public class REST_ReplyController {
    @Autowired
    private ReplyService replyService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    @PostMapping("/api/reps/comment/{idComment}")
    public ResponseEntity<Void> createReplyComment(@RequestBody Reply reply,
                                                   @PathVariable("idComment") Long idComment) {
        List<Reply> replyList = new ArrayList<>();
        Comment comment = commentService.findCommentById(idComment);
        if (comment != null) {
            reply.setUserReply(getUserFromToken());
            reply.setRepComment(comment);
            replyList.add(reply);
            comment.setReplyList(replyList);
            replyService.save(reply);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    private User getUserFromToken() {
        Object authen = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long idUser = ((UserPrinciple)authen).getId();
        User user = userService.findUserByID(idUser);
        return user;
    }

}
