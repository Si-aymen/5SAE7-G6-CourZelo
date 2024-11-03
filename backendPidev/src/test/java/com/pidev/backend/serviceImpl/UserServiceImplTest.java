package com.pidev.backend.serviceImpl;


import com.pidev.backend.entity.Classroom;
import com.pidev.backend.entity.Role;
import com.pidev.backend.entity.User;
import com.pidev.backend.repository.ClassroomRepository;
import com.pidev.backend.repository.UserRepository;
import com.pidev.backend.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private ClassroomRepository classroomRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User());
        when(userRepository.findAll()).thenReturn(users);

        List<User> result = userService.getAllUsers();
        assertEquals(1, result.size());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    public void testGetUserByLogin() {
        User user = new User();
        when(userRepository.findById("testLogin")).thenReturn(Optional.of(user));

        User result = userService.getUserByLogin("testLogin");
        assertNotNull(result);
        verify(userRepository, times(1)).findById("testLogin");
    }

    @Test
    public void testCreateUser_Success() {
        User user = new User();
        user.setEmail("test@example.com");
        user.setLogin("testLogin");

        when(userRepository.findUserByEmail("test@example.com")).thenReturn(null);
        when(userRepository.findUserByLogin("testLogin")).thenReturn(null);
        when(userRepository.save(user)).thenReturn(user);

        User result = userService.createUser(user);
        assertNotNull(result);
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void testCreateUser_Failure_DuplicateLoginOrEmail() {
        User user = new User();
        user.setEmail("duplicate@example.com");
        user.setLogin("duplicateLogin");

        when(userRepository.findUserByEmail("duplicate@example.com")).thenReturn(user);

        assertThrows(IllegalArgumentException.class, () -> userService.createUser(user));
    }

    @Test
    public void testUpdateUser_Success() {
        User existingUser = new User();
        existingUser.setLogin("testLogin");
        User updatedUser = new User();
        updatedUser.setLogin("testLogin");

        when(userRepository.findUserByLogin("testLogin")).thenReturn(existingUser);
        when(userRepository.save(updatedUser)).thenReturn(updatedUser);

        User result = userService.updateUser("testLogin", updatedUser);
        assertNotNull(result);
        verify(userRepository, times(1)).save(updatedUser);
    }

    @Test
    public void testUpdateUser_UserNotFound() {
        when(userRepository.findUserByLogin("nonexistentLogin")).thenReturn(null);

        User result = userService.updateUser("nonexistentLogin", new User());
        assertNull(result);
    }

    @Test
    public void testDeleteUser() {
        userService.deleteUser("testLogin");
        verify(userRepository, times(1)).deleteUserByLogin("testLogin");
    }

    @Test
    public void testGetTeachers() {
        User teacher = new User();
        when(userRepository.getUsersByRole(Role.TEACHER)).thenReturn(List.of(teacher));

        List<User> result = userService.getTeachers();
        assertEquals(1, result.size());
        verify(userRepository, times(1)).getUsersByRole(Role.TEACHER);
    }

    @Test
    public void testGetTeachersOfClassroom() {
        Classroom classroom = new Classroom();
        classroom.setId("classroomId");
        User teacher = new User();

        when(classroomRepository.findById("classroomId")).thenReturn(Optional.of(classroom));
        when(userRepository.getUserByClassroomsAndRole(classroom, Role.TEACHER)).thenReturn(List.of(teacher));

        List<User> result = userService.getTeachersOFClassroom("classroomId");
        assertEquals(1, result.size());
    }

    @Test
    public void testGetStudentsOfClassroom() {
        Classroom classroom = new Classroom();
        classroom.setId("classroomId");
        User student = new User();

        when(classroomRepository.findById("classroomId")).thenReturn(Optional.of(classroom));
        when(userRepository.getUserByClassroomsAndRole(classroom, Role.STUDENT)).thenReturn(List.of(student));

        List<User> result = userService.getStudentsOFClassroom("classroomId");
        assertEquals(1, result.size());
    }

    @Test
    public void testGetUserById() {
        User user = new User();
        when(userRepository.findById("testId")).thenReturn(Optional.of(user));

        User result = userService.getUserById("testId");
        assertNotNull(result);
        verify(userRepository, times(1)).findById("testId");
    }
}
