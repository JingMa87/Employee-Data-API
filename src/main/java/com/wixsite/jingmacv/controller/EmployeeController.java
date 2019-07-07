package com.wixsite.jingmacv.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wixsite.jingmacv.model.Address;
import com.wixsite.jingmacv.model.Employee;
import com.wixsite.jingmacv.service.EmployeeService;
import com.wixsite.jingmacv.util.HTTPHeaderUtil;

/*
 * Provides CRUD endpoints to the user for manipulating data in JSON and XML format.
 */
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getEmployees(String country) {
		return ResponseEntity.status(HttpStatus.OK).headers(HTTPHeaderUtil.getHeaders()).body(employeeService.getEmployees(country));
	}
	
	@GetMapping("/employee")
	@SuppressWarnings("rawtypes")
	public ResponseEntity getEmployee(long id) {
		Optional<Employee> employeeOpt = employeeService.getEmployee(id);
		return employeeOpt.isPresent() ? ResponseEntity.status(HttpStatus.OK).headers(HTTPHeaderUtil.getHeaders()).body(employeeOpt.get()) :
										 ResponseEntity.status(HttpStatus.NOT_FOUND).headers(HTTPHeaderUtil.getHeaders()).body("No employee with that ID.");
	}
	
	@PostMapping("/employee")
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee)  {
		boolean added = employeeService.addEmployee(employee);
		return added ? ResponseEntity.status(HttpStatus.CREATED).headers(HTTPHeaderUtil.getHeaders()).body("Successfully added.") :
					   ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(HTTPHeaderUtil.getHeaders()).body("Employee with that ID already exists.");
	}
	
	@PutMapping("/employee")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee)  {
		boolean updated = employeeService.updateEmployee(employee);
		return updated ? ResponseEntity.status(HttpStatus.OK).headers(HTTPHeaderUtil.getHeaders()).body("Successfully updated.") :
						 ResponseEntity.status(HttpStatus.NOT_FOUND).headers(HTTPHeaderUtil.getHeaders()).body("No employee with that ID.");
	}
	
	@DeleteMapping("/employee")
	public ResponseEntity<String> deleteEmployee(long id)  {
		employeeService.deleteEmployee(id);
		return ResponseEntity.status(HttpStatus.OK).headers(HTTPHeaderUtil.getHeaders()).body("Successfully deleted.");
	}
	
	@GetMapping("/firstNames")
	public ResponseEntity<List<String>> getFirstNames() {
		return ResponseEntity.status(HttpStatus.OK).headers(HTTPHeaderUtil.getHeaders()).body(employeeService.getFirstNames());
	}
	
	@GetMapping("/lastNames")
	public ResponseEntity<List<String>> getLastNames() {
		return ResponseEntity.status(HttpStatus.OK).headers(HTTPHeaderUtil.getHeaders()).body(employeeService.getLastNames());
	}
	
	@GetMapping("/addresses")
	public ResponseEntity<List<Address>> getAddresses() {
		return ResponseEntity.status(HttpStatus.OK).headers(HTTPHeaderUtil.getHeaders()).body(employeeService.getAddresses());
	}
	
	@GetMapping("/phoneNumbers")
	public ResponseEntity<List<String>> getPhoneNrs() {
		return ResponseEntity.status(HttpStatus.OK).headers(HTTPHeaderUtil.getHeaders()).body(employeeService.getPhoneNrs());
	}
	
	@GetMapping("/error")
	public ResponseEntity<String> getError() {
		return new ResponseEntity<String>("Unknown error. Contact IT support.", HTTPHeaderUtil.getHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
