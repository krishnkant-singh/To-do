package com.sqlquery;

import java.util.Arrays;
import java.util.List;
import org.hibernate.query.*;
import com.tut.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

public class sqlExample {
	public static void main(String[] args) {
		
		Configuration cfg= new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session =factory.openSession(); 
		session.beginTransaction(); 
		
		
		String s= "select * from Student";
	NativeQuery nq=session.createSQLQuery(s);
	 List<Object[]> list=	nq.list();
	 list.stream().map(q->Arrays.deepToString(q)).forEach(System.out::println);
		
	}

}
