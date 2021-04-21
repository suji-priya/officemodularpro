package com.acloudzyn.officemodularpro.service;

import java.util.List;

import com.acloudzyn.officemodularpro.model.Admin;
import com.acloudzyn.officemodularpro.model.Employee;
import com.acloudzyn.officemodularpro.model.Manager;

public interface AdminService {
	public String addAdmin(Admin theAdmin);

	public String addManager(Manager theManager);

	public String removeManager(int managerId);
    
	public String updateManager(Manager theManager);
	
	public List<Manager> getManagers();
	
	public Manager getManager(int managerId);
	
	public String addEmployee(Employee theEmployee);

    public String removeEmployee(int employeeId);
    
    public String updateEmployee(Employee theEmployee);
    
    public List<Employee> getEmployees();
    
    public Employee getEmployee(int employeeId);
    
    
}
