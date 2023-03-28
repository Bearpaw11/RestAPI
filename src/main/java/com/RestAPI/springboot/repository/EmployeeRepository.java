package com.RestAPI.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RestAPI.springboot.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
