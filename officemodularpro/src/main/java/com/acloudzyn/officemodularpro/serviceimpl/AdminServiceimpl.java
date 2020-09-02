package com.acloudzyn.officemodularpro.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.acloudzyn.officemodularpro.config.AuthenticationConfig;
import com.acloudzyn.officemodularpro.model.Admin;
import com.acloudzyn.officemodularpro.model.Employee;
import com.acloudzyn.officemodularpro.model.Manager;
import com.acloudzyn.officemodularpro.repository.AdminRepository;
import com.acloudzyn.officemodularpro.repository.EmployeeRepository;
import com.acloudzyn.officemodularpro.repository.ManagerRepository;
import com.acloudzyn.officemodularpro.service.AdminService;

@Service
public class AdminServiceimpl implements AdminService,UserDetailsService {

	/*
	 * @Value("${spring.security.user.name}") private String username;
	 * 
	 * @Value("${spring.security.user.password}") private String password;
	 */
	
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
		System.out.println("in admin service impl");
		String currentUserName = AuthenticationConfig.currentUser();
		Admin admin=adminRepository.findByFirstName(currentUserName);
	
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

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		     Admin admin=adminRepository.findByFirstName(username);
		     if (admin != null) {
		    	 UserDetails   user= User.withUsername(admin.getFirstName()).password(admin.getLastName()).authorities("write").build();  
			     return user;  
		    	 
		        }
		     throw new UsernameNotFoundException(username);
		     
		     
	}

}
