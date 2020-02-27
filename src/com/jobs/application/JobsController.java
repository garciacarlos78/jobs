package com.jobs.application;

import java.util.List;

import com.jobs.domain.AbsStaffMember;
import com.jobs.domain.Employee;
import com.jobs.persistence.EmployeeRepository;

public class JobsController {

	private EmployeeRepository repository = new EmployeeRepository();
	
	public JobsController(){
		//this.repository = new EmployeeRepository();	
	}
	
	public void createBossEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee boss = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateBoss());
		repository.addMember(boss);
	}
	
	public void createEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee boss = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateEmployee());
		repository.addMember(boss);
	}

	public void createManagerEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{
		Employee manager = new Employee(name, address, phone, salaryPerMonth, PaymentFactory.createPaymentRateManager());
		repository.addMember(manager);
	}


	public void payAllEmployeers() {

		// Get the list of all the employees
		List<AbsStaffMember> employees = repository.getAllMembers();
		
		// Iterate the list paying each member
		for (AbsStaffMember employee : employees) {
			employee.pay();
		}	
	}

	public String getAllEmployees() {

		StringBuilder sb = new StringBuilder();

		// Get the list of all the employees
		List<AbsStaffMember> employees = repository.getAllMembers();
		
		for (AbsStaffMember employee : employees) {
			sb.append("\n" + employee.toString());
		}
		
		return sb.toString();
	}

	public void createVolunteer(String name, String address, String phone) throws Exception{

		Employee volunteer = new Employee(name, address, phone);
		repository.addMember(volunteer);		
	}
}
