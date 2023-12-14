package com.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.Certificate;
import com.tut.Student;

public class StateDemo {
	public static void main(String [] args) {
		//Transient State 
		//Persistant State
		//Detached State
		//Removed State
		
		
		System.out.println("Example:");
		Configuration cfg= new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session= factory.openSession();
		
		Student st1=new Student();
		st1.setId(122);
		st1.setName("Ram");
		st1.setCity("koo");
		st1.setCerti(new Certificate("Java","2 months"));
		//Transient State 
		
		Transaction tx= session.beginTransaction();
		session.save(st1);
		tx.commit();
		
		
	}

}
