package com.example.crud.user.dao;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.crud.dao.EmployeeDaoImpl;
import com.example.crud.entities.Employee;
import com.example.crud.entities.User;
import com.example.crud.form.ViewUpdateForm;

import javassist.expr.Instanceof;

@Repository
@Transactional
public class UserTaskImpl implements UserTask{

	final private Logger logger = Logger.getLogger(UserTaskImpl.class);

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Employee> getAllUser() {
		List<Employee> list = manager.createNamedQuery("Employee.list", Employee.class).getResultList();
//		logger.debug(list);
		return list;
	}

	@Override
	public void Update(ViewUpdateForm form) {
//		logger.debug("Update method dao :");
		Employee emp = form.getEmployee();
		Employee employee = manager.find(Employee.class,emp.getID());
		
		
		Field[] empField = emp.getClass().getDeclaredFields();
		Field[] employeeField = employee.getClass().getDeclaredFields();
		
		for(int i = 0; i < empField.length;i++)
		{
			empField[i].setAccessible(true);
			employeeField[i].setAccessible(true);
			
			try {
					if(empField[i].get(emp)!=null && !empField[i].get(emp).equals(employeeField[i].get(employee)))
					{
						employeeField[i].set(employee, empField[i].get(emp));
					}
/*					logger.debug(employeeField[i].getName()+" > "+employeeField[i].get(employee));*/
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			
		}
		
		manager.merge(employee);
		manager.flush();
	}

	@Override
	public List<Employee> findByName(String name) {
		return manager.createNamedQuery("Employee.findbyname",Employee.class).setParameter("firstName", name).getResultList();
	}

	@Override
	public List<Employee> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> findbyContact(String contact) {
		// TODO Auto-generated method stub
		return null;
	}

}
