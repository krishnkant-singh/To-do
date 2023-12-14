package com.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.tut.Student;

public class CriteriaExample {
  public static void main(String[] args) {
		Configuration cfg= new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session =factory.openSession(); 
		session.beginTransaction(); 
		
		
		
		Criteria stu1=session.createCriteria(Student.class);
//		stu1.add(Restrictions.eq("certi.course", "Physics"));
//		stu1.add(Restrictions.lt("id", 24));
		stu1.add(Restrictions.like("certi.course", "P"));
		
		List<Student> st=stu1.list();
		
		for(Student s:st) {
			System.out.println(s);
		}
		
}
}
