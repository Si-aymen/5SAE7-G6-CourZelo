package com.pidev.backend.repository;

import com.pidev.backend.entity.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends MongoRepository<Department, String> {

    Department findDepartmentByDepartmentId(String id);
}
