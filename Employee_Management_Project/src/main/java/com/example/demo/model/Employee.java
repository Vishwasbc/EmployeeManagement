package com.example.demo.model;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int empId;
	private String empName;
	private int empSal;
	private String empDesg;
	@JsonFormat(pattern = "dd-mm-yyyy")
	private Date empDOJ;
}
