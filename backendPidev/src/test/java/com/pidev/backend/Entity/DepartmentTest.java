package com.pidev.backend.Entity;

import org.junit.jupiter.api.BeforeEach; // Change to JUnit 5 import
import org.junit.jupiter.api.Test; // Change to JUnit 5 import
import org.junit.jupiter.api.extension.ExtendWith; // Import for extension
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension; // JUnit 5 Mockito extension

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals; // JUnit 5 assertions
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class) // Use Mockito extension
public class DepartmentTest {

    @InjectMocks
    private Department department;

    @Mock
    private List<User> teachers;

    @BeforeEach // Updated to JUnit 5 equivalent
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        // No need to instantiate department again
    }

    @Test // Remains the same
    public void testSetAndGetDepartmentId() {
        String departmentId = "dept001";
        department.setDepartmentId(departmentId);
        assertEquals("dept001", department.getDepartmentId());
    }

    @Test // Remains the same
    public void testSetAndGetName() {
        String name = "Mathematics";
        department.setName(name);
        assertEquals("Mathematics", department.getName());
    }

    @Test // Remains the same
    public void testSetAndGetContactInformation() {
        String contactInfo = "contact@university.edu";
        department.setContactInformation(contactInfo);
        assertEquals("contact@university.edu", department.getContactInformation());
    }

    @Test // Remains the same
    public void testSetAndGetTeachers() {
        List<User> mockTeachers = new ArrayList<>();
        mockTeachers.add(mock(User.class));
        department.setTeachers(mockTeachers);

        assertNotNull(department.getTeachers());
        assertEquals(1, department.getTeachers().size());
    }
}
