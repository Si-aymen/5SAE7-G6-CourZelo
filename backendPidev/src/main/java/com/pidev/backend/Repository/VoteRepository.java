package com.pidev.backend.Repository;

import com.pidev.backend.Entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends JpaRepository<Vote, String> {
    Vote findByQuestionAndUser(String idquestion, String idUser);//Qbyvote
}
