package com.pidev.backend.repository;

import com.pidev.backend.entity.Course;
import com.pidev.backend.entity.Speciality;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends MongoRepository<Course, String> {
    List<Course> getCourseByCourseDomain(Speciality speciality);
}
