package com.acloudzyn.officemodularpro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acloudzyn.officemodularpro.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
