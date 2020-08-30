package com.acloudzyn.officemodularpro.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.acloudzyn.officemodularpro.model.Admin;
import com.acloudzyn.officemodularpro.model.Employee;
import com.acloudzyn.officemodularpro.model.Manager;
import com.acloudzyn.officemodularpro.repository.AdminRepository;
import com.acloudzyn.officemodularpro.repository.EmployeeRepository;
import com.acloudzyn.officemodularpro.repository.ManagerRepository;
import com.acloudzyn.officemodularpro.service.AdminService;

@Service
public class AdminServiceimpl implements AdminService {

	@Autowired
	AdminRepository adminRepository;

	@Autowired
	ManagerRepository managerRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public String addAdmin(Admin theAdmin) {

		adminRepository.save(theAdmin);

		return "Admin Added Successfully";
	}

	@Override
	public String addManager(Manager theManager) {
		System.out.println("akash");
		System.out.println("in admin service impl");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUserName = authentication.getName();
		System.out.println(currentUserName);
		Admin admin=adminRepository.findByFirstName(currentUserName);
		//Admin admin=adminRepository.findById(1).get();
		theManager.setTheAdmin(admin);

		managerRepository.save(theManager);

		return "Manager Added Successfully";
	}

	@Override
	public String removeManager(int managerId) {
		Optional<Manager> manager = managerRepository.findById(managerId);
		if (manager.isPresent()) {
			managerRepository.deleteById(managerId);
			return "Manager Deleted Successfully";
		}
		return null;
	}

	@Override
	public String updateManager(Manager theManager) {
		Optional<Manager> manager = managerRepository.findById(theManager.getId());
		if (manager.isPresent()) {
			managerRepository.save(theManager);

			return "Manager Updated Successfully";
		}
		return null;
	}

	@Override
	public List<Manager> getManagers() {
		List<Manager> managers = managerRepository.findAll();
		return managers;
	}

	@Override
	public Manager getManager(int managerId) {
		Optional<Manager> manager = managerRepository.findById(managerId);

		if (manager.isPresent()) {

			return manager.get();
		}
		return null;
	}

	@Override
	public String addEmployee(Employee theEmployee) {
		//Manager m=managerRepository.findById(theEmployee.getTheManager().getId()).get();
		Manager m=managerRepository.findByCity(theEmployee.getCity());
		theEmployee.setTheManager(m);
		
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
