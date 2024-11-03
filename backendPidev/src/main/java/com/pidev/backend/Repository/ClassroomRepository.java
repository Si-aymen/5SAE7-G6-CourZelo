package com.pidev.backend.repository;

import com.pidev.backend.entity.Classroom;
import com.pidev.backend.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassroomRepository extends MongoRepository<Classroom, String> {
    Classroom getClassroomByClassroomName(String lvl );
    Classroom getClassroomById(String id) ;
    List<Classroom> getClassroomByTeachersContains(User teacher);
    List<Classroom> getClassroomByStudnetsContains(User student);

}
