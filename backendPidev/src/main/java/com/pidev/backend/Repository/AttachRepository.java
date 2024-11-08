package com.pidev.backend.Repository;

import com.pidev.backend.Entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachRepository extends JpaRepository<Attachment, String> {}
