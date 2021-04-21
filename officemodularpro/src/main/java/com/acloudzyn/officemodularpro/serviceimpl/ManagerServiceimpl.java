package com.acloudzyn.officemodularpro.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acloudzyn.officemodularpro.model.Employee;
import com.acloudzyn.officemodularpro.repository.EmployeeRepository;
import com.acloudzyn.officemodularpro.service.ManagerService;

@Service
public class ManagerServiceimpl implements ManagerService {
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public String addEmployee(Employee theEmployee) {
		employeeRepository.save(theEmployee);

		return "Employee Added Successfully";

	}

	@Override
	public String removeEmployee(int employeeId) {

		Optional<Employee> employee = employeeRepository.findById(employeeId);

		if (employee.isPresent()) {

			employeeRepository.deleteById(employeeId);

			return "Employee Deleted Successfully";
		}

		return null;
	}

	@Override
	public String updateEmployee(Employee theEmployee) {
		Optional<Employee> employee = employeeRepository.findById(theEmployee.getId());
		if (employee.isPresent()) {

			employeeRepository.save(theEmployee);

			return "Employee Updated Successfully";
		}
		return null;
	}

	@Override
	public List<Employee> getEmployees() {

		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployee(int employeeId) {
		Optional<Employee> employee = employeeRepository.findById(employeeId);
		if (employee.isPresent()) {
			return employee.get();
		}
		return null;
	}

	
	
}
