package com.pidev.backend.Entity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
@RunWith(MockitoJUnitRunner.class)

public class DepartmentTest {

    @InjectMocks
    private Department department;

    @Mock
    private List<User> teachers;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        department = new Department();
    }

    @Test
    public void testSetAndGetDepartmentId() {
        String departmentId = "dept001";
        department.setDepartmentId(departmentId);
        assertEquals("dept001", department.getDepartmentId());
    }

    @Test
    public void testSetAndGetName() {
        String name = "Mathematics";
        department.setName(name);
        assertEquals("Mathematics", department.getName());
    }

    @Test
    public void testSetAndGetContactInformation() {
        String contactInfo = "contact@university.edu";
        department.setContactInformation(contactInfo);
        assertEquals("contact@university.edu", department.getContactInformation());
    }

    @Test
    public void testSetAndGetTeachers() {
        List<User> mockTeachers = new ArrayList<>();
        mockTeachers.add(mock(User.class));
        department.setTeachers(mockTeachers);

        assertNotNull(department.getTeachers());
        assertEquals(1, department.getTeachers().size());
    }
}
