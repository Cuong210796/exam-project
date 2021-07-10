package com.cuong.service.Impl;

import com.cuong.model.Blog;
import com.cuong.model.Tags;
import com.cuong.model.User;
import com.cuong.repository.BlogRepository;
import com.cuong.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public void save(Blog blog) {
        Date date = Calendar.getInstance().getTime();
        String pattern = "MM/dd/yyyy HH:mm:ss";
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        String strDate = dateFormat.format(date);
        blog.setCreateDate(strDate);
        blogRepository.save(blog);
    }

    @Override
    public void remote(Blog blog) {
        blogRepository.delete(blog);
    }


    @Override
    public List<Blog> findAllBlogByIdOderById() {
        return blogRepository.findAllByIdOrderById();
    }


    @Override
    public List<Blog> findAllByUserId(Long id) {
        return blogRepository.findAllByUserIdAndOrderByIdDesc(id);
    }

    @Override
    public Blog findByIdAndUser(Long id, User user) {
        return blogRepository.findByIdAndUser(id, user);
    }

    @Override
    public List<Blog> findAllByTitleContaining(String title) {
        return blogRepository.findAllByTitleContaining(title);
    }

    @Override
    public List<Blog> findAllByTitleContainingAndUser(String title, User user) {
        return blogRepository.findAllByTitleContainingAndUser(title, user);
    }

    @Override
    public List<Blog> findByTags(Tags tags) {
        return blogRepository.findAllByTags(tags);
    }
}
