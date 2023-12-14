package com.tut;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Hello World!" );
        
        SessionFactory factory=new Configuration().configure().buildSessionFactory();
        
        
        System.out.println(factory.isClosed());
        Student stu=new Student();
        stu.setId(3);
        stu.setName("verevwe");
        stu.setCity("vnevwrveui");
        Session session = factory.getCurrentSession();
       session.beginTransaction();
       session.save(stu);
       session.getTransaction().commit();
       session.close();
        System.out.println(stu.toString());
        
//        Address ad= new Address();
//        ad.setStreet("Street 1");
//         ad.setCity("Delhi");
//         ad.setOpen(false);
//         ad.setAddedDate(new Date());
//         ad.setX(102.3);
//         //rEADING image
//         FileInputStream fis= new FileInputStream("src/main/java/favicon.png");
//        byte[] data = new byte[fis.available()];
//         fis.read(data);
//         ad.setImage(data);
//         Session session1 = factory.getCurrentSession();
//         session1.beginTransaction(); 
//         session1.save(ad);
//         session1.getTransaction().commit();
//         session1.close();
//         System.out.println(ad.toString());
    }
    
}
