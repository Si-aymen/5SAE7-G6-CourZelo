package com.pidev.backend.repository;

import com.pidev.backend.entity.Conversation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversationRepository extends MongoRepository<Conversation,String> {
}
