package com.pidev.backend.repository;


import com.pidev.backend.entity.Chapter;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ChapterRepository extends MongoRepository<Chapter,String> {

}
