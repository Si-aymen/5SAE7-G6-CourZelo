package com.pidev.backend.service;

import com.pidev.backend.entity.Course;
import com.pidev.backend.entity.Speciality;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CourseService {
    Course addCourse (Course course);
    List<Course> getALLCourses();
    Course modifyCourse (Course course);
    public void deleteCourse(String CourseId);

    public void uploadPdf(MultipartFile file, String courseId) ;

    public List<Course> getCoursessByClassroom(String classroomId) ;

    Course getCourseById(String courseId) ;

    void courseEnroll(String IdStudnet , String IDCourse);
    List<Course> getCourseByCourseDomain(Speciality speciality) ;

     Course addRating(String IdUser , String IDcourse,Float Rating);

     Course AddChapterToCourse (String IDCourse , String IDChapter) ;

}
