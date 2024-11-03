package com.pidev.backend.repository;

import com.pidev.backend.entity.Attachment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachRepository extends MongoRepository<Attachment, String> {}
