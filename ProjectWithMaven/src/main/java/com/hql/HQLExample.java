package com.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.query.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.Student;

public class HQLExample {

	public static void main(String[] args) {
		
		Configuration cfg= new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session =factory.openSession(); 
		session.beginTransaction(); 
		//hql
		//Syntax
		String query="from Student as s where s.city =:x and s.name=:n ";
		
		Query q=session.createQuery(query);
		q.setParameter("x","kuju");
		q.setParameter("n", "ere");
		//SIngle result or multiple result
		List<Student>ld =q.list();
		
		for(Student st:ld) {
			
//			System.out.println(st.getName());
			System.out.println("Student [id=" + st.getId() + ", name=" + st.getName() + ", city=" + st.getCity() + "]");
		}
		System.out.println("-----------------------------");
//Delete Query 
		//		Query q1=session.createQuery("delete from Student as s where s.city=:p");
//		q1.setParameter("p","kuju");
//		int a=q1.executeUpdate();
		Query q1=session.createQuery("update from Student s set s.city =:p where s.name =:e");
		q1.setParameter("p","lo");
		q1.setParameter("e","Ram");
		int a=q1.executeUpdate();
		System.out.println(a);
		//How to execute join column
		
		Query q2= session.createQuery("select q.question,q.questionId,a.answer ,a.answerId from Question q Inner Join  q.answer as a");
//       q2.executeUpdate();
      List<Object []> list2 =q2.getResultList();
      for(Object[] arr:list2) {
    	  System.out.println(Arrays.toString(arr));
      }
       
		
		
		session.close();
		
		
		
		
		
		factory.close();
	}
}
