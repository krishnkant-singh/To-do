<%@ page import="com.helper.FactoryProvider"%>
<%@ page import="org.hibernate.Session"%>
<%@ page import="org.hibernate.query.*"%>
<%@ page import="com.entities.Note"%>
<%@ page import="java.util.List"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Add Notes</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link href="css/style.css" rel="stylesheet"/>
    <link rel="icon" href="img/icons8-note-64.png" type="image/x-icon">
  </head>
  
  <body>
   <div class ="container-fluid">
   <%@include file='navbar.jsp'%>
   <br>
   <h1>Edit your Note</h1>
   <form action="UpdateServlet" method="post">
  <div class="mb-3">
   <%
   Session s=FactoryProvider.getFactory().openSession();
    		int note_id=Integer.parseInt(request.getParameter("note_id"));
	Query q=s.createQuery("from Note n where n.id=: x ");
	q.setParameter("x", note_id);

	List<Note> list=q.getResultList(); 
   Note note=list.get(0);
   %>
   <input type="hidden" name="note_id" value="<%= note_id %>">

    <label for="title" class="form-label">Note Title</label>
    <input name="title"  value="<%= note.getTitle() %>"  
    required type="text" class="form-control" id="title" aria-describedby="emailHelp">
    
  <div class="mb-3">
    <label for="content" >Note Content</label>
  
  	<textarea
  	 id="content" 
  	 name ="content"  placeholder="<%=note.getContent() %>" 
  	 class ="form-control"
  	 style="height:300px"><%= note != null ? note.getContent() : "" %></textarea>
  </div>
  <div class="mb-3 form-check">
    <input type="checkbox" class="form-check-input" id="exampleCheck1">
    <label class="form-check-label" for="exampleCheck1">Check me out</label>
  </div>
  <div class="container text-center">
  <button type="submit" class="btn btn-success">Save Note</button>
  </div>
</form>
   </div>
   <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
   
   
  </body>
  
</html> 