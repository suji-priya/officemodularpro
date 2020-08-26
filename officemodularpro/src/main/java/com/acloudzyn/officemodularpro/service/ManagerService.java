package com.acloudzyn.officemodularpro.service;

import java.util.List;

import com.acloudzyn.officemodularpro.model.Employee;
import com.acloudzyn.officemodularpro.model.Manager;

public interface ManagerService {

	public String addEmployee(Employee theEmployee);

	public String removeEmployee(int employeeId);

	public String updateEmployee(Employee theEmployee);

	public List<Employee> getEmployees();

	public Employee getEmployee(int employeeId);
}
