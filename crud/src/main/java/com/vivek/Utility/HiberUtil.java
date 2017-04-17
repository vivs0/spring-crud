package com.vivek.Utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HiberUtil {
	private static final SessionFactory SESSION_FACTORY = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory(){
		try{
			return new Configuration().configure().buildSessionFactory();
		}catch(Throwable ex){
			System.err.println("Initial Session Factory creation faild "+ex);
			throw new 	ExceptionInInitializerError();
		}
	}
	
	public static SessionFactory getSessionFactory(){
		return SESSION_FACTORY;
	}
	
	public static void shutdown(){
		getSessionFactory().close();
	}
}
