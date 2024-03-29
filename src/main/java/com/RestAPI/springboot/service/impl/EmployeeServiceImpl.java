package com.RestAPI.springboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.RestAPI.springboot.exception.ResourceNotFoundException;
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

	@Override 
	public Employee getEmployeeById(long id){
//		Optional <Employee> employee = employeeRepository.findById(id);
//		if(employee.isPresent()) {
//			return employee.get();
//		}else {
//			throw new ResourceNotFoundException("Employee", "Id", id);	
//		}
		return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
		}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		//check if employee exists with given id
		
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		 //save exisiting employee to DB
		employeeRepository.save(existingEmployee);
		return existingEmployee;
		}
	

	@Override
	public void deleteEmployee(long id) {
		// Check if employee exists by id
		employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
		//delete employee
		employeeRepository.deleteById(id);
	}

}
