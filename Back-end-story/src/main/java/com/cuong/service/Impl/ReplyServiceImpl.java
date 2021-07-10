package com.cuong.service.Impl;

import com.cuong.model.Reply;
import com.cuong.repository.ReplyRepository;
import com.cuong.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyServiceImpl implements ReplyService {
    @Autowired
    private ReplyRepository replyRepository;

    @Override
    public void save(Reply reply) {
        replyRepository.save(reply);
    }
}
