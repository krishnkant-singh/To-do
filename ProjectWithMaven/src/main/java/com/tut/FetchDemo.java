package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

	public static void main(String [] args) {
		Configuration cfg= new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session= factory.openSession();
		//get-student:106
//		Student student=(Student)session.load(Student.class,2);
//		System.out.println(student);
		Address add=(Address)session.load(Address.class,3);
		System.out.print(add.getCity());
		session.close();
		factory.close();
	}
}
