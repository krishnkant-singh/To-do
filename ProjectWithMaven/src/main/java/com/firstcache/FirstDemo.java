package com.firstcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.Student;

public class FirstDemo {
	public static void main(String[] args) {
		Configuration cfg= new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session =factory.openSession(); 
		session.beginTransaction(); 
		//By Default Enable 
		
		Student stu=session.get(Student.class, 1);
		System.out.println(stu);
		System.out.println("working something ");
		System.out.println(session.contains(stu));
		Student stu1=session.get(Student.class, 1);
		System.out.println(stu1);
		session.close();
		System.out.println(session.contains(stu));
		
		
		
	}

}
