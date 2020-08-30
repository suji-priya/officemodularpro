package com.acloudzyn.officemodularpro.rest;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acloudzyn.officemodularpro.model.Admin;
import com.acloudzyn.officemodularpro.model.Employee;
import com.acloudzyn.officemodularpro.model.Manager;
import com.acloudzyn.officemodularpro.service.AdminService;


@RestController
@RequestMapping("/admin_api")
public class AdminController {

	private static final Logger log = LogManager.getLogger(AdminController.class);
	
	@Autowired
	AdminService adminservice;
	
	

	@PostMapping("/admin")
	public ResponseEntity<String> addAdmin(@RequestBody Admin theAdmin) {

		if (theAdmin != null) {
			String msg = adminservice.addAdmin(theAdmin);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		}

		return new ResponseEntity<String>("Please Fill All The Details", HttpStatus.BAD_REQUEST);

	}

	@PostMapping("/manager")
	public ResponseEntity<String> addManager(@RequestBody Manager theManager) {
		//System.out.println("in add manager method");
		//Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		//String currentUserName = authentication.getName();
		//System.out.println(currentUserName);
		if (theManager != null) {

			String msg = adminservice.addManager(theManager);

			return new ResponseEntity<String>(msg, HttpStatus.OK);
		}

		return new ResponseEntity<String>("Please Fill All The Details", HttpStatus.BAD_REQUEST);

	}

	@DeleteMapping("/manager/{managerId}")
	public ResponseEntity<String> removeManager(@PathVariable int managerId) {

		String msg = adminservice.removeManager(managerId);
		if (msg != null) {
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		}

		return new ResponseEntity<String>("Selected Manager Doesn't Exist", HttpStatus.NOT_FOUND);

	}

	@PutMapping("/manager")
	public ResponseEntity<String> updateManager(@RequestBody Manager theManager) {

		String msg = adminservice.updateManager(theManager);
		if (theManager != null) {
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		}
		return new ResponseEntity<String>("Manager Not Exist", HttpStatus.NOT_FOUND);

	}

	@GetMapping("/manager")
	public ResponseEntity<Object> getManagers() {
		List<Manager> managers = adminservice.getManagers();
		if (managers.isEmpty()) {
			return new ResponseEntity<Object>("Manager Doesnot Exist", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Object>(managers, HttpStatus.OK);

	}

	@GetMapping("/manager/{managerId}")
	public ResponseEntity<Object> getManager(@PathVariable int managerId) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUserName = authentication.getName();
		System.out.println(" in get manager "+currentUserName);
		Manager manager = adminservice.getManager(managerId);
		if (manager != null) {

			return new ResponseEntity<Object>(manager, HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Manager Doesnot Exist", HttpStatus.NOT_FOUND);

	}

	@PostMapping("/employee")
	public ResponseEntity<String> addEmployee(@RequestBody Employee theEmployee) {

		if (theEmployee != null) {
			String msg = adminservice.addEmployee(theEmployee);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		}

		return new ResponseEntity<String>("Please Fill All The Details", HttpStatus.BAD_REQUEST);

	}

	@DeleteMapping("/employee/{employeeId}")
	public ResponseEntity<String> removeEmployee(@PathVariable int employeeId) {
		String msg = adminservice.removeEmployee(employeeId);
		if (msg != null) {
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		}

		return new ResponseEntity<String>("Selected Employee Doesn't Exist", HttpStatus.NOT_FOUND);

	}

	@PutMapping("/employee")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee theEmployee) {

		String msg = adminservice.updateEmployee(theEmployee);
		if (msg != null) {
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		}

		return new ResponseEntity<String>("Employee DoesNot Exist", HttpStatus.NOT_FOUND);

	}

	@GetMapping("/employee")
	public ResponseEntity<Object> getEmployees() {
		List<Employee> employees = adminservice.getEmployees();
		if (employees.isEmpty()) {
			return new ResponseEntity<Object>("Employess Not Present", HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<Object>(employees, HttpStatus.OK);

	}

	@GetMapping("/employee/{employeeId}")
	public ResponseEntity<Object> getEmployee(@PathVariable int employeeId) {

		Employee employee = adminservice.getEmployee(employeeId);
		if (employee != null) {

			return new ResponseEntity<Object>(employee, HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Employee Doesnot Exist", HttpStatus.NOT_FOUND);

	}
}
