package com.cuong.repository;

import com.cuong.model.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tags, Long> {
    Tags findByName(String name);

    Boolean existsByName(String name);
}
