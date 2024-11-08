package com.pidev.backend.Repository;

import com.pidev.backend.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {

    Department findDepartmentByDepartmentId(String id);
}
