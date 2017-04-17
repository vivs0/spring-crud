package test;
import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.crud.HomeController;
import com.example.crud.entities.User;
import com.example.crud.form.ViewUpdateForm;
import com.google.gson.Gson;
import com.example.crud.entities.Employee;
import com.example.crud.entities.Gender;
import com.example.crud.entities.Status;

@Transactional
@Repository
public class tests {
	private static Logger logger = Logger.getLogger(tests.class);
	
	private static EntityManager manager;
	
	public static void main(String[] args) {
/*		ApplicationContext context = new ClassPathXmlApplicationContext("test/applicationContext.xml");
		EntityManagerFactory factory = (EntityManagerFactory)context.getBean("entityManagerFactory");
		manager = factory.createEntityManager();
		EntityTransaction t = manager.getTransaction();
		t.begin();
		Employee emp = new Employee();
		emp.setContact(98899L);
		emp.setEmail("saini#gmail");
		emp.setFirstName("rahul");
		emp.setGender("MALE");
		
		Status s = new Status(10);
		User user = new User("saini0532","asdf",s);
		emp.setUser(user);
		user.setEmployee(emp);
		manager.persist(emp);
		t.commit();
*/
		ApplicationContext context = new ClassPathXmlApplicationContext("test/applicationContext.xml");
		EntityManagerFactory factory = (EntityManagerFactory)context.getBean("entityManagerFactory");
		manager = factory.createEntityManager();
		EntityTransaction t = manager.getTransaction();
		t.begin();
		Employee emp = manager.find(Employee.class, 22);
/*		String First_Name = "vivs0532";
		List<Employee> employee = manager.createQuery("select emp from Employee emp where emp.user.username = :name")
				.setParameter("name", First_Name).getResultList();*/

		List<Employee> employee = manager.createNamedQuery("Employee.findbyname", Employee.class).setParameter("firstName", "vivek").getResultList();
		logger.debug(employee);
		manager.close();
		
		
//		t.commit();

	}
	
	
	static Employee getEmployee(User user)
	{
		Employee employee = new Employee();
		employee.setFirstName("lovy");
		employee.setContact(Long.parseLong("9889321024"));
		employee.setEmail("xxxxx@gmafl.com");
		employee.setUser(user);
		return employee;
	}
	public static void pl()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("test/applicationContext.xml");
		EntityManagerFactory factory = (EntityManagerFactory)context.getBean("entityManagerFactory");
		manager = factory.createEntityManager();
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<User> criteria = builder.createQuery(User.class);
		Root<User> root = criteria.from(User.class);
//		List list = manager.createNamedQuery("User.list", User.class).getResultList();
/*		logger.debug(manager);*/
	//	logger.debug(list);
		
	}

}