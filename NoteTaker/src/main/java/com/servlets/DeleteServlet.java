package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;

import com.helper.FactoryProvider;

/**
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
			 int noteId= Integer.parseInt(request.getParameter("note_id").trim());
				Session s=FactoryProvider.getFactory().openSession();
				s.beginTransaction(); 
				Query q=s.createQuery("Delete from Note n where n.id = :x");
				q.setParameter("x",noteId);
				q.executeUpdate();
				response.sendRedirect("all_notes.jsp");
				
				s.close();
				
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		
	}



}
