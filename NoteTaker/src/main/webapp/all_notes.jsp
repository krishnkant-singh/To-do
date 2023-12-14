<%@ page import="com.helper.FactoryProvider"%>
<%@ page import="org.hibernate.Session"%>
<%@ page import="org.hibernate.query.*"%>
<%@ page import="com.entities.Note"%>
<%@ page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Notes</title>
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link href="css/style.css" rel="stylesheet"/>
    <link rel="icon" href="img/icons8-note-64.png" type="image/x-icon">
</head>
<body>
 <%@include file='navbar.jsp'%>
 <br>
 <div class ="container">
 <h1 class="text-uppercase">All Notes:</h1>
 <div class="row"  >
 <div class="col-12">
  <% 
 	Session s=FactoryProvider.getFactory().openSession();
 	Query q=s.createQuery("from Note n order by n.addedDate desc ");
 	List<Note> list=q.list();
 	for(Note note:list){
 		
 		%>
 		<div class="card mt-3" >
  <img class=" m-4 mx-auto " src="img/icons8-note-64.png"style="max-width:70px " class="card-img-top" alt="...">
  <div class="card-body px-5">
    <h5 class="card-title"><%=note.getTitle() %></h5>
    <p class="card-text">
    <%=note.getContent() %>
   </p >
   <p><b><%=note.getAddedDate()%></b></p>
   <div style='text-align:center' mt-2>
    <a href="DeleteServlet?note_id=<%=note.getId() %>" class="btn btn-danger">Delete</a>
     <a href="edit.jsp?note_id=<%=note.getId() %>" class="btn btn-primary">Update</a>
     </div>
  </div>
</div>
 		
 <%
 		
 	}
 	
 
 s.close();
 
 
 %>
 
 </div>
  </div>
  </div>


  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
   
</body>
</html>