package com.pidev.backend.Repository;

import com.pidev.backend.Entity.Course;
import com.pidev.backend.Entity.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {
    List<Course> getCourseByCourseDomain(Speciality speciality);
}
