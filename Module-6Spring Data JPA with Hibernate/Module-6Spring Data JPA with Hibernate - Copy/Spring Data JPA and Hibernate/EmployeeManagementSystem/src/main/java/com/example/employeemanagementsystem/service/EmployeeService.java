package com.example.employeemanagementsystem.service;

import com.example.employeemanagementsystem.entity.Employee;
import com.example.employeemanagementsystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public Page<Employee> getEmployees(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.findAll(pageable);
    }

    public Page<Employee> getEmployeesSorted(int page, int size, String field) {
        Pageable pageable =
                PageRequest.of(page, size, Sort.by(field).ascending());

        return repository.findAll(pageable);
    }
}