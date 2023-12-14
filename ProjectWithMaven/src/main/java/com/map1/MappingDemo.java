package com.map1;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo {
	public static void main(String []args) {
		Configuration cfg= new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session =factory.openSession();
		Transaction tx=session.beginTransaction();
		List<Project> pro = new ArrayList();
		List<Emp> emp = new ArrayList();
		Emp e1= new Emp();
		Emp e2= new Emp();
		e1.setEid(1);
		e1.setName("Ram");
		
		e2.setEid(2);
		e2.setName("Shyam");
		emp.add(e1);
		
		
		 
		Project p1= new Project();
		Project p2= new Project();
		p1.setPid(1);
		p1.setProjectname("Chat-Bot");
	    p1.setEmployee(emp);
		p2.setPid(2);
		p2.setProjectname("Open-Ai");
		p1.setEmployee(emp);
		emp.add(e2);
		p2.setEmployee(emp);
		pro.add(p1);
		
//		e1.setProjects(pro);
		pro.add(p2);
 		e2.setProjects(pro); 
		session.save(p1);
		session.save(p2);
		session.save(e1);
		session.save(e2);
		
		session.getTransaction().commit();
		
		
		
	
		
	}
}
