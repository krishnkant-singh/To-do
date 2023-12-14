package com.mapping.xml;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class test {
	public static void main(String[] args) {
		Configuration cfg= new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session =factory.openSession(); 
		session.beginTransaction(); 
		Person p=new Person(1,"Ram","delhi","908899309");
		session.save(p);
		
		session.getTransaction().commit();
		
	}

}
