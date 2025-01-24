package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.exception.EmptyEmployeeListException;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService service;

	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp) throws EmployeeNotFoundException {
		return service.addEmployee(emp);
	}

	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp) throws EmployeeNotFoundException {
		return service.updateEmployee(emp);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable int id) {
		return service.deleteEmployee(id);
	}

	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable int id) throws EmployeeNotFoundException {
		return service.getEmployee(id);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployee() throws EmptyEmployeeListException {
		return service.getAllEmployee();
	}

	@GetMapping("/all/{lowLimit}/{highLimit}")
	public ResponseEntity<List<Employee>> getAllBetweenSalary(@PathVariable int lowLimit, @PathVariable int highLimit)
			throws EmptyEmployeeListException {
		return service.getAllBetweenSalary(lowLimit, highLimit);
	}
	@GetMapping("/all/{desg}")
	public ResponseEntity<List<Employee>> getAllDesg(@PathVariable String desg) throws EmptyEmployeeListException{
		return service.getAllDesg(desg);
	}
	@GetMapping("/allSal/{sal}")
	public ResponseEntity<List<Employee>> getAllSalLessThan(@PathVariable int sal) throws EmptyEmployeeListException{
		return service.findAllEmployeeByEmpSalLessThan(sal);
	}
}
