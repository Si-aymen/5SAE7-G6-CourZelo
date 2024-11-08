package com.pidev.backend.Repository;

import com.pidev.backend.Entity.Glossary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface GlossaryRepository extends JpaRepository<Glossary, String> {


     //Flux<Glossary> findByTermContainingIgnoreCase(String term);
}
