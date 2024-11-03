package com.pidev.backend.repository;

import com.pidev.backend.entity.Hashtag;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HashtagRepository extends MongoRepository<Hashtag, String> {
}
