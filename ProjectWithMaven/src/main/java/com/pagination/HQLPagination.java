package com.pagination;

import org.hibernate.query.*;
import com.tut.Student;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HQLPagination {
     
	public static void main(String[] args) {
		Configuration cfg= new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session =factory.openSession(); 
		session.beginTransaction(); 
		
		Query <Student> query= session.createQuery("from Student");
		
		
		//Implementing Pagination
		for(int i=0;i<50;i=i+10) {
			
		query.setFirstResult(i);
		query.setMaxResults(10);
		List<Student> list=query.list();
		list.stream().forEach(System.out::println);
		System.out.println("---------");
		
		}
		factory.close();
		
	}
}
