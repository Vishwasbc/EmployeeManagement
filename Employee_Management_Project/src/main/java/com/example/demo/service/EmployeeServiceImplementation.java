package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public String addEmployee(Employee emp) {
		Employee employee = empRepo.save(emp);
		if(employee!=null) {
			return "Saved Employee";
		}else {
			return "Not Saved";
		}
	}
}
