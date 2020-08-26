package com.acloudzyn.officemodularpro.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acloudzyn.officemodularpro.model.Employee;
import com.acloudzyn.officemodularpro.service.ManagerService;

@RestController
@RequestMapping("/manager_api")
public class ManagerController {
	@Autowired
	ManagerService managerservice;
	
	
	@PostMapping("/employee")
	public ResponseEntity<String> addEmployee(@RequestBody Employee theEmployee) {

		if (theEmployee != null) {
			String msg = managerservice.addEmployee(theEmployee);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		}

		return new ResponseEntity<String>("Please Fill All The Details", HttpStatus.BAD_REQUEST);

	}

	@DeleteMapping("/employee/{employeeId}")
	public ResponseEntity<String> removeEmployee(@PathVariable int employeeId) {
		String msg = managerservice.removeEmployee(employeeId);
		if (msg != null) {
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		}

		return new ResponseEntity<String>("Selected Employee Doesn't Exist", HttpStatus.NOT_FOUND);

	}

	@PutMapping("/employee")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee theEmployee) {

		String msg = managerservice.updateEmployee(theEmployee);
		if (msg != null) {
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		}

		return new ResponseEntity<String>("Employee DoesNot Exist", HttpStatus.NOT_FOUND);

	}

	@GetMapping("/employee")
	public ResponseEntity<Object> getEmployees() {
		List<Employee> employees = managerservice.getEmployees();
		if (employees.isEmpty()) {
			return new ResponseEntity<Object>("Employess Not Present", HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<Object>(employees, HttpStatus.OK);

	}

	@GetMapping("/employee/{employeeId}")
	public ResponseEntity<Object> getEmployee(@PathVariable int employeeId) {

		Employee employee = managerservice.getEmployee(employeeId);
		if (employee != null) {

			return new ResponseEntity<Object>(employee, HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Employee Doesnot Exist", HttpStatus.NOT_FOUND);

	}

}
