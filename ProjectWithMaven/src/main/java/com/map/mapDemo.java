package com.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class mapDemo {

	public static void main(String[] args) {
		
		Configuration cfg= new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session =factory.openSession(); 
		session.beginTransaction(); 
		Question question = new Question(); 
		question.setQuestionId(1);
//		question.setQuestion("what is java?");
//		Answer answer= new Answer();
//		answer.setAnswerId(1);
//		answer.setAnswer("java is a hll ....");
//		answer.setQuestion(question);
////		question.setAnswer(answer);
//		session.save(answer);
//		session.save(question);
//		List<Answer> ans1= new ArrayList<Answer>();
//		ans1.add(answer);
//		
//		Answer answer1= new Answer();
//		
//		answer1.setAnswerId(2);
//		answer1.setAnswer("java is a programming language");
//		answer1.setQuestion(question);
//		ans1.add(answer1);
//		question.setAnswer(ans1);
//		session.save(answer);
//		session.save(answer1);
//		session.save(question);
//		
//		session.getTransaction().commit();
		
		
		
//		Answer ans=(Answer)session.get(Answer.class, 1);
//		System.out.println(ans.getAnswer());
		Question que=(Question)session.load(Question.class, 1);
		que.setQuestion("pqmw");
	session.getTransaction().commit();
//		System.out.println(que.getQuestion());
//		for(Answer an: que.getAnswer()) {
//			System.out.println(an.getAnswer());
//		}
//		System.out.println(que.getAnswer());
		session.close();
		}
}
