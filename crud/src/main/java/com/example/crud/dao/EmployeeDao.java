package com.example.crud.dao;

import java.util.List;

import com.example.crud.entities.Employee;
import com.example.crud.form.EmployeeRegisterationForm;

public interface EmployeeDao {
	
	public void Register(EmployeeRegisterationForm form) throws Exception;
}
