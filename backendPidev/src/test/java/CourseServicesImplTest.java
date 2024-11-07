package com.pidev.backend.ServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.pidev.backend.Entity.Course;
import com.pidev.backend.Repository.CourseRepository;
import com.pidev.backend.ServiceImpl.CourseServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class CourseServiceImplTest {

    @Mock
    private CourseRepository courseRepository;

    @InjectMocks
    private CourseServiceImpl courseService;

    private Course course;

    @BeforeEach
    public void setUp() {
        course = new Course();
        course.setId("1");
        course.setCourseName("Test Course");
        course.setCourseLevel("Beginner");
    }

    @Test
    public void testGetAllCourses() {
        when(courseRepository.findAll()).thenReturn(Arrays.asList(course));

        List<Course> courses = courseService.getALLCourses();

        assertThat(courses).hasSize(1);
        assertThat(courses.get(0).getId()).isEqualTo("1");
    }

    @Test
    public void testAddCourse() {
        when(courseRepository.save(any(Course.class))).thenReturn(course);

        Course savedCourse = courseService.addCourse(course);

        assertThat(savedCourse.getId()).isEqualTo("1");
        assertThat(savedCourse.getCourseName()).isEqualTo("Test Course");
    }

    @Test
    public void testModifyCourse() {
        when(courseRepository.save(any(Course.class))).thenReturn(course);

        Course modifiedCourse = courseService.modifyCourse(course);

        assertThat(modifiedCourse.getId()).isEqualTo("1");
        assertThat(modifiedCourse.getCourseName()).isEqualTo("Test Course");
    }

    @Test
    public void testDeleteCourse() {
        when(courseRepository.findById("1")).thenReturn(Optional.of(course));

        courseService.deleteCourse("1");

        verify(courseRepository, times(1)).delete(course);
    }

    @Test
    public void testGetCourseById() {
        when(courseRepository.findById("1")).thenReturn(Optional.of(course));

        Course foundCourse = courseService.getCourseById("1");

        assertThat(foundCourse).isNotNull();
        assertThat(foundCourse.getId()).isEqualTo("1");
    }

    @Test
    public void testGetCourseById_NotFound() {
        when(courseRepository.findById("1")).thenReturn(Optional.empty());

        try {
            courseService.getCourseById("1");
        } catch (Exception e) {
            assertThat(e).isInstanceOf(EntityNotFoundException.class);
        }
    }
}
