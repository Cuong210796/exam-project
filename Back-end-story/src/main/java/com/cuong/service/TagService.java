package com.cuong.service;

import com.cuong.model.Tags;

public interface TagService {
    void save(Tags tags);

    Tags findByName(String name);

    Boolean existsByName(String name);
}
