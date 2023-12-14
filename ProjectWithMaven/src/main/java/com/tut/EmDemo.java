package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class EmDemo {
	public static void main(String [] args) {
		Configuration cfg= new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session= factory.openSession();
		Student student1= new Student();
		student1.setId(12);
		student1.setCity("fasca");
		student1.setName("ankit");
		Certificate certi = new Certificate();
		certi.setCourse("android");
		certi.setDuration("2 months");
		student1.setCerti(certi);
		session.beginTransaction();
		session.save(student1);
		
		
		
		
		Student student2= new Student();
		student2.setId(13);
		student2.setCity("asasca");
		student2.setName("lfkit");
		Certificate certi1 = new Certificate();
		certi1.setCourse("roid");
		certi1.setDuration("onths");
		student2.setCerti(certi1);
	
		session.save(student2);
		session.getTransaction().commit();
		
		
		
		
		factory.close();
		
	}

}
