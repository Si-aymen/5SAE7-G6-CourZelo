package com.pidev.backend.Repository;


import com.pidev.backend.Entity.Chapter;
import com.pidev.backend.Entity.Classroom;
import com.pidev.backend.Entity.Role;

import com.pidev.backend.Entity.Speciality;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Set;


@Repository
public interface ChapterRepository extends JpaRepository<Chapter,String> {

}
