package com.RestAPI.springboot.service;

import java.util.List;

import com.RestAPI.springboot.model.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(long id);
	

}
