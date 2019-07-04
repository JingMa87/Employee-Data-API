package com.wixsite.jingmacv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wixsite.jingmacv.model.Employee;

/*
 * Provides access to the DB.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
