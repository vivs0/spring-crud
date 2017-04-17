package com.example.crud.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.example.crud.entities.User;
import com.example.crud.form.EmployeeRegisterationForm;
import com.example.crud.service.EmployeeServiceImpl;
import com.example.crud.entities.Employee;
import com.example.crud.entities.Status;

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {

		
	@PersistenceContext
	private EntityManager emf;

	final private Logger logger = Logger.getLogger(EmployeeDaoImpl.class);

	@Override
	public void Register(EmployeeRegisterationForm form) throws Exception{
		logger.debug("debug : Reached dao layer");
		User user = form.getUser();
		Employee emp = form.getEmployee();
		user.setEmployee(emp);
		user.setStatusId(new Status(10));
		emp.setUser(user);
		emf.persist(emp);
		}


}
