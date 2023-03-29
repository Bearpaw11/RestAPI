package com.RestAPI.springboot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.RestAPI.springboot.model.Employee;
import com.RestAPI.springboot.repository.EmployeeRepository;
import com.RestAPI.springboot.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	

}
