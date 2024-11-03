package com.pidev.backend.serviceImpl;


import com.pidev.backend.entity.Classroom;
import com.pidev.backend.entity.Course;
import com.pidev.backend.entity.Role;
import com.pidev.backend.entity.User;
import com.pidev.backend.repository.ClassroomRepository;
import com.pidev.backend.repository.CourseRepository;
import com.pidev.backend.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ClassroomTest {


    @Mock
    private ClassroomRepository classroomRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private CourseRepository courseRepository;

    @InjectMocks
    private ClassroomServiceImpl classroomService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllClassrooms() {
        List<Classroom> classrooms = new ArrayList<>();
        classrooms.add(new Classroom());
        when(classroomRepository.findAll()).thenReturn(classrooms);

        List<Classroom> result = classroomService.GetAllClassrooms();

        assertEquals(1, result.size());
        verify(classroomRepository, times(1)).findAll();
    }

    @Test
    void testGetClassroomByClassroomLevel() {
        Classroom classroom = new Classroom();
        when(classroomRepository.getClassroomByClassroomName("level1")).thenReturn(classroom);

        Classroom result = classroomService.GetClassroomByClassroomLevel("level1");

        assertEquals(classroom, result);
        verify(classroomRepository, times(1)).getClassroomByClassroomName("level1");
    }

  /*  @Test
    void testAddClassroom() {
        Classroom classroom = new Classroom();
        when(classroomRepository.save(any(Classroom.class))).thenReturn(classroom);
        Classroom result = classroomService.AddClassroom(classroom);
        assertEquals(classroom, result);
        verify(classroomRepository, times(1)).save(classroom);
    }
    */


    @Test
    void testDeleteClassroom() {
        Classroom classroom = new Classroom();
        when(classroomRepository.getClassroomByClassroomName("class1")).thenReturn(classroom);

        classroomService.DeleteClassroom("class1");

        verify(classroomRepository, times(1)).getClassroomByClassroomName("class1");
        verify(classroomRepository, times(1)).delete(classroom);
    }

    @Test
    void testAddTeachersToClassroom() {
        Classroom classroom = new Classroom();
        User teacher = new User();
        teacher.setRole(Role.TEACHER);
        teacher.setLogin("teacher1");

        when(classroomRepository.getClassroomByClassroomName("class1")).thenReturn(classroom);
        when(userRepository.getUserByLoginAndRole("teacher1", Role.TEACHER)).thenReturn(teacher);

        List<String> teachers = List.of("teacher1");
        classroomService.AddTeachersToClassroom("class1", teachers);

        verify(classroomRepository, times(1)).getClassroomByClassroomName("class1");
        verify(userRepository, times(1)).getUserByLoginAndRole("teacher1", Role.TEACHER);
        verify(classroomRepository, times(1)).save(classroom);
    }

    @Test
    void testAddStudentsToClassroom() {
        Classroom classroom = new Classroom();
        User student = new User();
        student.setRole(Role.STUDENT);
        student.setLogin("student1");

        when(classroomRepository.getClassroomByClassroomName("class1")).thenReturn(classroom);
        when(userRepository.getUserByLoginAndRole("student1", Role.STUDENT)).thenReturn(student);

        List<String> students = List.of("student1");
        classroomService.AddStudnetsToClassroom("class1", students);

        verify(classroomRepository, times(1)).getClassroomByClassroomName("class1");
        verify(userRepository, times(1)).getUserByLoginAndRole("student1", Role.STUDENT);
        verify(classroomRepository, times(1)).save(classroom);
    }

    @Test
    void testAddCoursesToClassroom() {
        Classroom classroom = new Classroom();
        Course course = new Course();
        course.setId("course1");

        when(classroomRepository.getClassroomByClassroomName("class1")).thenReturn(classroom);
        when(courseRepository.findById("course1")).thenReturn(Optional.of(course));

        List<String> courses = List.of("course1");
        classroomService.AddCoursesToClassroom("class1", courses);

        verify(classroomRepository, times(1)).getClassroomByClassroomName("class1");
        verify(courseRepository, times(1)).findById("course1");
        verify(classroomRepository, times(1)).save(classroom);
    }

    @Test
    void testGetById() {
        Classroom classroom = new Classroom();
        when(classroomRepository.findById("class1")).thenReturn(Optional.of(classroom));

        Classroom result = classroomService.GetById("class1");

        assertEquals(classroom, result);
        verify(classroomRepository, times(1)).findById("class1");
    }

    @Test
    void testDeleteClassroomById() {
        classroomService.DeleteClassroomById("class1");

        verify(classroomRepository, times(1)).deleteById("class1");
    }


}
