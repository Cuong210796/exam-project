package com.cuong.service;

import com.cuong.model.BlogImg;
import com.cuong.model.User;

import java.util.List;

public interface BlogImgService {
    void save(BlogImg blogImg);

    List<BlogImg> getAllBlogImgByUser(User user);

    BlogImg findById(Long id);

    BlogImg findByIdAndUser(Long id, User user);

    void deleteBlogImg(Long idBlogImg);
}
