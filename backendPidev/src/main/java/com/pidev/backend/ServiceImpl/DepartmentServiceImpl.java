package com.pidev.backend.serviceImpl;

import com.pidev.backend.entity.Department;
import com.pidev.backend.repository.DepartmentRepository;
import com.pidev.backend.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository = new DepartmentRepository() {
        @Override
        public Department findDepartmentByDepartmentId(String id) {
            return null;
        }

        @Override
        public <S extends Department> S insert(S entity) {
            return null;
        }

        @Override
        public <S extends Department> List<S> insert(Iterable<S> entities) {
            return List.of();
        }

        @Override
        public <S extends Department> List<S> findAll(Example<S> example) {
            return List.of();
        }

        @Override
        public <S extends Department> List<S> findAll(Example<S> example, Sort sort) {
            return List.of();
        }

        @Override
        public <S extends Department> List<S> saveAll(Iterable<S> entities) {
            return List.of();
        }

        @Override
        public List<Department> findAll() {
            return List.of();
        }

        @Override
        public List<Department> findAllById(Iterable<String> strings) {
            return List.of();
        }

        @Override
        public <S extends Department> S save(S entity) {
            return null;
        }

        @Override
        public Optional<Department> findById(String s) {
            return Optional.empty();
        }

        @Override
        public boolean existsById(String s) {
            return false;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(String s) {

        }

        @Override
        public void delete(Department entity) {

        }

        @Override
        public void deleteAllById(Iterable<? extends String> strings) {

        }

        @Override
        public void deleteAll(Iterable<? extends Department> entities) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public List<Department> findAll(Sort sort) {
            return List.of();
        }

        @Override
        public Page<Department> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Department> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends Department> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Department> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends Department> boolean exists(Example<S> example) {
            return false;
        }

        @Override
        public <S extends Department, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
            return null;
        }
    };

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(String departmentId) {
        return departmentRepository.findById(departmentId).orElse(null);
    }

    @Override
    public Department createDepartment(Department department) {
        if (departmentRepository.findDepartmentByDepartmentId(department.getDepartmentId()) != null) {
            throw new IllegalArgumentException("Department with the same ID already exists.");
        }
        return departmentRepository.save(department);
    }

    @Override
    public void deleteDepartment(String departmentId) {
        if (departmentRepository.existsById(departmentId)) {
            departmentRepository.deleteById(departmentId);
        } else {
            throw new IllegalArgumentException("Department ID does not exist.");
        }
    }

    @Override
    public Department updateDepartment(String id, Department department) {
        Department existingDepartment = departmentRepository.findDepartmentByDepartmentId(id);
        if (existingDepartment != null) {
            department.setDepartmentId(existingDepartment.getDepartmentId());
            return departmentRepository.save(department);
        } else {
            throw new IllegalArgumentException("Department ID not found.");
        }
    }

    @Override
    public Department affectTeacherToDep(String login, String id) {
        // Implementation needed
        return null;
    }
}
