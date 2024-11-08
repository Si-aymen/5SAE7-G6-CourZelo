package com.pidev.backend.service;

import com.pidev.backend.entity.Department;
import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartments();
    Department getDepartmentById(String departmentId);
    Department createDepartment(Department user);
    void deleteDepartment(String departmentId);
    Department updateDepartment(String id, Department department);

    Department affectTeacherToDep(String login, String id);
}
