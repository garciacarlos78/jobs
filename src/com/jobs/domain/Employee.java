package com.jobs.domain;

public class Employee extends AbsStaffMember {

	protected double salaryPerMonth;
	protected IPaymentRate paymentRate;	

	public Employee(String name, String address, String phone, double salaryPerMonth,IPaymentRate paymentRate) throws Exception {
		super(name, address, phone);		
		if(salaryPerMonth<0) throw new Exception();
		if(paymentRate==null) throw new Exception();
				
		this.salaryPerMonth=salaryPerMonth;
		this.paymentRate=paymentRate;
	}
	
	
	public Employee(String name, String address, String phone) throws Exception {
		super(name, address, phone);
		this.salaryPerMonth=0;
	}


	@Override
	public void pay() {
		
		// Check volunteer case
		if (this.salaryPerMonth==0) totalPaid=0;
		
		// Rest of cases
		else totalPaid=paymentRate.pay(salaryPerMonth);		
	}


	@Override
	public String toString() {
		return "Employee [name=" + name + ", address=" + address + ", phone=" + phone + ", totalPaid=" + totalPaid
				+ "]";
	}}
