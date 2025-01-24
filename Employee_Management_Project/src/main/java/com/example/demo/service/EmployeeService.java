package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.exception.EmptyEmployeeListException;
import com.example.demo.model.Employee;

public interface EmployeeService {

	public abstract ResponseEntity<Employee> addEmployee(Employee emp) throws EmployeeNotFoundException;

	public abstract ResponseEntity<Employee> updateEmployee(Employee emp) throws EmployeeNotFoundException;

	public abstract String deleteEmployee(int empId);

	public abstract Employee getEmployee(int empId) throws EmployeeNotFoundException;

	public abstract ResponseEntity<List<Employee>> getAllEmployee() throws EmptyEmployeeListException;

	public abstract ResponseEntity<List<Employee>> getAllBetweenSalary(int lowLimit, int highLimit)
			throws EmptyEmployeeListException;

	public abstract ResponseEntity<List<Employee>> getAllDesg(String desg) throws EmptyEmployeeListException;
	
	public abstract ResponseEntity<List<Employee>> findAllEmployeeByEmpSalLessThan(int sal) throws EmptyEmployeeListException;
}
