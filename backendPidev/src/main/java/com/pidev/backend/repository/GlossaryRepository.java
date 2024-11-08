package com.pidev.backend.repository;

import com.pidev.backend.entity.Glossary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface GlossaryRepository extends MongoRepository<Glossary, String> {


     //Flux<Glossary> findByTermContainingIgnoreCase(String term);
}
