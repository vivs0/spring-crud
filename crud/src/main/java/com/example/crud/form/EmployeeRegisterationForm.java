package com.example.crud.form;

import javax.validation.Valid;

import com.example.crud.entities.Employee;
import com.example.crud.entities.User;

public class EmployeeRegisterationForm {

	@Valid
	private Employee employee;

	@Valid
	private User user;
	
	public EmployeeRegisterationForm() {
	}

	public EmployeeRegisterationForm(Employee employee, User user) {
		this.employee = employee;
		this.user = user;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "EmployeeRegisterationForm [employee=" + employee + ", user=" + user + "]";
	}
	
	
}
