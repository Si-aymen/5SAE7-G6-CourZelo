package com.pidev.backend.repository;

import com.pidev.backend.entity.Vote;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends MongoRepository<Vote, String> {
    Vote findByQuestionAndUser(String idquestion, String idUser);//Qbyvote
}
