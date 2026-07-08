package com.example.employeemanagementsystem.controller;

import com.example.employeemanagementsystem.entity.Department;
import com.example.employeemanagementsystem.repository.DepartmentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentRepository repository;

    public DepartmentController(DepartmentRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Department saveDepartment(@RequestBody Department department) {
        return repository.save(department);
    }

    @GetMapping
    public List<Department> getAllDepartments() {
        return repository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        repository.deleteById(id);
    }
}