package com.pidev.backend.repository;

import com.pidev.backend.entity.SignalBadword;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignaBAdWordRepository extends MongoRepository<SignalBadword, String> {
}
