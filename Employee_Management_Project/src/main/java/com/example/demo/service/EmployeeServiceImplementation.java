package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.exception.EmptyEmployeeListException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImplementation implements EmployeeService {
	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public ResponseEntity<Employee> addEmployee(Employee emp) throws EmployeeNotFoundException {
		Employee saved = empRepo.save(emp);
		if (saved == null)
			throw new EmployeeNotFoundException("Employee Not Found");
		return new ResponseEntity<>(saved, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Employee> updateEmployee(Employee emp) throws EmployeeNotFoundException {
		Employee saved = empRepo.save(emp);
		if (saved == null)
			throw new EmployeeNotFoundException("Employee Not Found");
		return new ResponseEntity<>(saved, HttpStatus.OK);
	}

	@Override
	public String deleteEmployee(int empId) {
		empRepo.deleteById(empId);
		return "Employee Successfully Deleted";
	}

	@Override
	public Employee getEmployee(int empId) throws EmployeeNotFoundException {
		Optional<Employee> employee = empRepo.findById(empId);
		if (employee.isPresent())
			return employee.get();
		else
			throw new EmployeeNotFoundException("Employee Not Found");
	}

	@Override
	public ResponseEntity<List<Employee>> getAllEmployee() throws EmptyEmployeeListException {
		List<Employee> list = empRepo.findAll();
		if (list == null)
			throw new EmptyEmployeeListException("Employee List is null");
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<Employee>> getAllBetweenSalary(int lowLimit, int highLimit)
			throws EmptyEmployeeListException {
		List<Employee> list =empRepo.getAllBetweenSalary(lowLimit, highLimit);
		if (list == null)
			throw new EmptyEmployeeListException("Employee List is null");
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<Employee>> getAllDesg(String desg) throws EmptyEmployeeListException {
		List<Employee> list = empRepo.getAllDesg(desg);
		if (list == null)
			throw new EmptyEmployeeListException("Employee List is Null");
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<Employee>> findAllEmployeeByEmpSalLessThan(int sal) throws EmptyEmployeeListException {
		List<Employee> list = empRepo.findAllEmployeeByEmpSalLessThanEqual(sal);
		if(list==null)
			throw new EmptyEmployeeListException("Employee list is Null");
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
}
