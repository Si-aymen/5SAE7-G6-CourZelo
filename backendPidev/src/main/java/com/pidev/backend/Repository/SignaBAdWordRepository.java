package com.pidev.backend.Repository;

import com.pidev.backend.Entity.SignalBadword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignaBAdWordRepository extends JpaRepository<SignalBadword, String> {
}
