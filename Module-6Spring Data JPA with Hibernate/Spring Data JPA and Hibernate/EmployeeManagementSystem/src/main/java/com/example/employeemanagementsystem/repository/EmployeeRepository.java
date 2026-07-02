package com.example.employeemanagementsystem.repository;

import com.example.employeemanagementsystem.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Exercise 5
    List<Employee> findByName(String name);

    List<Employee> findByEmail(String email);

    List<Employee> findByDepartmentName(String name);

    @Query("SELECT e FROM Employee e WHERE e.email LIKE %:domain%")
    List<Employee> findByEmailDomain(@Param("domain") String domain);

    // Exercise 6
    @Query(name = "Employee.findEmployeeByName")
    List<Employee> findEmployeeByName(@Param("name") String name);

    // Exercise 9 (Optional)
    // JpaRepository already provides this method,
    // but you can keep it for the exercise.
    Page<Employee> findAll(Pageable pageable);
}