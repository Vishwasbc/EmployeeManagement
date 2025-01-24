package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	@Query("SELECT e FROM Employee e WHERE e.empSal BETWEEN :lowLimit AND :highLimit")
	public List<Employee> getAllBetweenSalary(int lowLimit,int highLimit);
	@Query("SELECT e FROM Employee e WHERE e.empDesg = :desg")
	public List<Employee> getAllDesg(String desg);
	public List<Employee> findAllEmployeeByEmpSalLessThanEqual(int sal);
}
