package com.example.crud.form;

import javax.persistence.Entity;
import javax.validation.Valid;

import com.example.crud.entities.Employee;
import com.example.crud.entities.Status;
import com.example.crud.entities.User;


public class ViewUpdateForm {
	
	@Valid
	private Employee employee;
	
	@Valid
	private User user;

	private Status status;

	public ViewUpdateForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ViewUpdateForm(Employee employee, User user, Status status) {
		super();
		this.employee = employee;
		this.user = user;
		this.status = status;
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ViewUpdateForm [employee=" + employee + ", user=" + user + ", status=" + status + "]";
	}
	
}
