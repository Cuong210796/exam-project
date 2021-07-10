package com.cuong.service.Impl;

import com.cuong.model.Tags;
import com.cuong.repository.TagRepository;
import com.cuong.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Override
    public void save(Tags tags) {
        tagRepository.save(tags);
    }

    @Override
    public Tags findByName(String name) {
        return tagRepository.findByName(name);
    }

    @Override
    public Boolean existsByName(String name) {
        return tagRepository.existsByName(name);
    }
}
