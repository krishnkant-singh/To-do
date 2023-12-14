package com.secondcache;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cache.ehcache.internal.EhcacheRegionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.Student;

import net.sf.ehcache.hibernate.EhCacheRegionFactory;

public class secondCacheExample {

	
	public static void main(String[] args) {
		Configuration cfg= new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session1 =factory.openSession();
		session1.beginTransaction(); 
		Student stu=session1.get(Student.class, 1);
		System.out.println(stu);
		session1.close();
		
		
		Session session2 =factory.openSession();
		Student stu1=session2.get(Student.class, 1);
		System.out.println(stu1);
		session2.beginTransaction(); 
		
		session2.close();
	}
}
