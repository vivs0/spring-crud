package com.example.crud.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.crud.HomeController;
import com.example.crud.dao.EmployeeDao;
import com.example.crud.entities.Employee;
import com.example.crud.form.EmployeeRegisterationForm;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDao task;
	final private Logger logger = Logger.getLogger(EmployeeServiceImpl.class);
	
	@Override
	public void Register(EmployeeRegisterationForm employee) throws Exception {
		task.Register(employee);
	}

}
