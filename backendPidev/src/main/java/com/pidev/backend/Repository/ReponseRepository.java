package com.pidev.backend.Repository;


import com.pidev.backend.Entity.Reponse;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface ReponseRepository extends JpaRepository<Reponse, String> {
}
