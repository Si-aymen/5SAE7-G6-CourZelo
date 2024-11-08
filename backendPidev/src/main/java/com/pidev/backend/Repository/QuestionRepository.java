package com.pidev.backend.Repository;

import com.pidev.backend.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, String> {
    List<Question> findByContenue(String contenue);//rech
}
