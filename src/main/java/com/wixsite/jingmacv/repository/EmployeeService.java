package com.wixsite.jingmacv.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wixsite.jingmacv.model.Address;
import com.wixsite.jingmacv.model.Employee;

/*
 * Provides the business logic between the API endpoints and the DB.
 */
@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getEmployees(String country) {
		List<Employee> employees = employeeRepository.findAll();
		return country != null ? employees.stream().filter(emp -> emp.getAddress().getCountry().contains(country)).collect(Collectors.toList()) : employees;
	}
	
	public Optional<Employee> getEmployee(long id) {
		return employeeRepository.findById(id);
	}
	
	public boolean addEmployee(Employee employee) {
		Optional<Employee> employeeOpt = employeeRepository.findById(employee.getId());
		if(!employeeOpt.isPresent()) {
			employeeRepository.save(employee);
			return true;
		}
		return false;
	}
	
	public boolean updateEmployee(Employee employee) {
		Optional<Employee> employeeOpt = employeeRepository.findById(employee.getId());
		if(employeeOpt.isPresent()) {
			employeeRepository.save(employee);
			return true;
		}
		return false;
	}
	
	public void deleteEmployee(long id) {
		employeeRepository.deleteById(id);
	}
	
	public List<String> getFirstNames() {
		return employeeRepository.findAll().stream().map(Employee::getFirstName).collect(Collectors.toList());
	}
	
	public List<String> getLastNames() {
		return employeeRepository.findAll().stream().map(Employee::getLastName).collect(Collectors.toList());
	}
	
	public List<Address> getAddresses() {
		return employeeRepository.findAll().stream().map(Employee::getAddress).collect(Collectors.toList());
	}
	
	public List<String> getPhoneNrs() {
		return employeeRepository.findAll().stream().map(Employee::getPhoneNumber).collect(Collectors.toList());
	}
}
