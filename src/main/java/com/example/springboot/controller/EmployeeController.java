package com.example.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.model.Employee;
import com.example.springboot.repository.EmployeeRepository;


@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EmployeeController {

	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	// get all employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
	
		@PostMapping("/employees")
		public Employee createEmployee(@RequestBody Employee employee) {
			return employeeRepository.save(employee);
		}
		
		@GetMapping("/employees/{id}")
		public Employee getEmployee(@PathVariable long id) {
			return employeeRepository.findById(id).get();
		}
		
		@PutMapping("/employees")
		public Employee updateEmployee(@RequestBody Employee employee) {
			return employeeRepository.save(employee);
		}
		@DeleteMapping("/employees/{id}")
		public String deleteEmployee(@PathVariable long id) {
			try {
				employeeRepository.deleteById(id);
				return "Employee deleted";
			}
			catch(Exception e) {
				return "Error";
			}
			
			}
}
