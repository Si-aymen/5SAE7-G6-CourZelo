package com.pidev.backend.controller;

import com.pidev.backend.entity.Department;
import com.pidev.backend.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200",exposedHeaders="Access-Control-Allow-Origin" )
@RequestMapping("/Departments")
public class DepartmentController {
    private final DepartmentService departmentService;


    @GetMapping("/GetAllDepartments")
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public Department getDepartmentbyId(@PathVariable String id){
        return departmentService.getDepartmentById(id);
    }

    @PostMapping("/Save/department")
    public Department createDepartment(@RequestBody Department department){
        return departmentService.createDepartment(department);
    }
    @PutMapping("{id}")
    public Department updateDepartment(@PathVariable String id,@RequestBody Department dep)
    {
        return departmentService.updateDepartment(id,dep);
    }

    @DeleteMapping("/{id}")
    public void deleteDep(@PathVariable String id){
        departmentService.deleteDepartment(id);
    }

}
