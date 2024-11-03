package com.pidev.backend.repository;


import com.pidev.backend.entity.Reponse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReponseRepository extends MongoRepository<Reponse, String> {
}
