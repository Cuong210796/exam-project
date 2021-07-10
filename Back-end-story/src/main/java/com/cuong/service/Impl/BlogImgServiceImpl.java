package com.cuong.service.Impl;

import com.cuong.model.BlogImg;
import com.cuong.model.User;
import com.cuong.repository.BlogImgRepository;
import com.cuong.service.BlogImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class BlogImgServiceImpl implements BlogImgService {

    @Autowired
    private BlogImgRepository blogImgRepository;

    @Override
    public void save(BlogImg blogImg) {
        Date date = Calendar.getInstance().getTime();
        String pattern = "MM/dd/yyyy HH:mm:ss";
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        String strDate = dateFormat.format(date);
        blogImg.setCreateDate(strDate);
        blogImgRepository.save(blogImg);
    }

    @Override
    public List<BlogImg> getAllBlogImgByUser(User user) {
        return blogImgRepository.findAllByUser(user);
    }


    @Override
    public BlogImg findById(Long id) {
        return blogImgRepository.findById(id).get();
    }

    @Override
    public BlogImg findByIdAndUser(Long id, User user) {
        return blogImgRepository.findByIdAndUser(id, user);
    }

    @Override
    public void deleteBlogImg(Long idBlogImg) {
        blogImgRepository.deleteById(idBlogImg);
    }
}
