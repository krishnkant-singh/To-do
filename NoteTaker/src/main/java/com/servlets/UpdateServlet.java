package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;
import com.helper.FactoryProvider;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UpdateServlet() {
        super();
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			 int noteId= Integer.parseInt(request.getParameter("note_id").trim());
				Session s=FactoryProvider.getFactory().openSession();
//				s.beginTransaction(); 
				String title=request.getParameter("title");
				String content =request.getParameter("content");
				
				
				
				Transaction tx= s.beginTransaction();
				
				
				
				Query q=s.createQuery("update  Note n set n.title=: p ,n.addedDate=:s, n.content=:t where n.id =:x");
				q.setParameter("p",title);
				q.setParameter("t",content);
				q.setParameter("x",noteId);
				q.setParameter("s",new Date());
				q.executeUpdate();
				response.setContentType("text/html");
				PrintWriter out=response.getWriter();
				out.println("<h1 style='text-align:center' >Note is updated successfully </h1>");
				out.println("<h1 style='text-align:center'><a href='all_notes.jsp'>View all notes</a></h1>");
				
				
//				response.sendRedirect("all_notes.jsp");
				
				s.close();
				
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
	}

}
