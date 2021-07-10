package com.cuong.repository;

import com.cuong.model.BlogImg;
import com.cuong.model.MyUpload;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MyUploadRepository extends JpaRepository<MyUpload, Long> {
   // List<MyUpload> findAllByUserId(Long id);
    List<MyUpload> findAllByBlogImg(BlogImg blogImg);
    void deleteAllByBlogImgId(Long id);

}
