package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			 String searchId = request.getParameter("search_id");
				Session s=FactoryProvider.getFactory().openSession();
//				s.beginTransaction(); 
			
				
				
				
				Transaction tx= s.beginTransaction();
				
				
				
				
				Query q = s.createQuery("FROM Note n WHERE n.title LIKE :p OR n.content LIKE :p");
				q.setParameter("p", "%" + searchId + "%");
				for(Note note:(List<Note>)q.list()){
					System.out.println(note.getContent());
					
				}
				List<Note> searchResults = (List<Note>)q.list();

				// Store the search results in the request attribute
			
				
				
				request.getSession().setAttribute("searchResults", searchResults);
				response.sendRedirect("Searched.jsp");

				
				
				
				s.close();
				
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
	}

}
