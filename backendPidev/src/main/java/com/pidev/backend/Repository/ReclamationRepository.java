package com.pidev.backend.Repository;

import com.pidev.backend.Entity.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReclamationRepository extends JpaRepository<Reclamation, String> {
    List<Reclamation> findByUser_Id(String userId);
}
