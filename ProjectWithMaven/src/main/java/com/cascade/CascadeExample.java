package com.cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.map.Answer;
import com.map.Question;

public class CascadeExample {
	public static void main(String[] args) {
		Configuration cfg= new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session =factory.openSession(); 
		session.beginTransaction(); 
		
		Question q1=new Question();
		q1.setQuestionId(567);
		q1.setQuestion("WHAT IS CASCADING");
		Answer a1=new Answer(908,"in hibernate its an important concept",q1);
		Answer a2=new Answer(998,"in hibernate its an important concept 1",q1);
		Answer a3=new Answer(956,"in hibernate its an important concept 2",q1);
		List<Answer> l1= new ArrayList<>();
		l1.add(a3);
		l1.add(a1);
		l1.add(a2);
		q1.setAnswer(l1);
		session.save(q1);
//		session.save(a1);
//		session.save(a2);
//		session.save(a3);
		session.getTransaction().commit();
		session.close();
		factory.close();
		
	}

}
