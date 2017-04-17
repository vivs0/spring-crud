package com.example.crud.service;

import java.util.List;

import com.example.crud.entities.Employee;
import com.example.crud.form.EmployeeRegisterationForm;

public interface EmployeeService {
	public void Register(EmployeeRegisterationForm form) throws Exception;
	}
