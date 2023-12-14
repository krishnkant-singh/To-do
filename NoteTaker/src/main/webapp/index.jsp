<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link href="css/style.css" rel="stylesheet"/>
    
    <link rel="icon" href="img/icons8-note-64.png" type="image/x-icon">
      <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f8f9fa;
            
        }

        .card-container {
            display: flex;
            justify-content: space-around;
            margin-top: 50px;
        }

        .card {
            width: 300px;
            border: 1px solid #ced4da;
            border-radius: 8px;
            overflow: hidden;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            transition: transform 0.3s;
            
        }

        .card:hover {
            transform: scale(1.05);
        }

        .card img {
            width: 100%;
            height: auto;
            border-bottom: 1px solid #ced4da;
        }

        .card-content {
            padding: 20px;
        }
         a {
            text-decoration: none;
        }

        .card-title {
        
            font-size: 1.5rem;
            font-weight: bold;
            margin-bottom: 10px;
        }

        .card-text {
            color: #495057;
            
        }
    </style>
  </head>
  
  <body>
   <div class ="container-fluid ">
   <%@include file='navbar.jsp'%>
    <br>
  
   </br>
<div class="card-container">
    <div class="card">
     <a href="add_notes.jsp" >
        <img src="img/save-note.jpg" alt="Card Image">
        <div class="card-content">
            <h5 class="card-title">Add Note</h5>
            <p class="card-text">You can add notes ... to revise later</p>
        </div>
    </div>

    <div class="card">
     <a href="all_notes.jsp" >
        <img src="img/showw_notes.avif" alt="Card Image">
        <div class="card-content">
            <h5 class="card-title">Show Note</h5>
            <p class="card-text">Revise from notes</p>
        </div>
    </div>

    <!-- Add more cards as needed -->
</div>
        
        <!-- Add more cards as needed -->

  
   </div>
   <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
   
   
  </body>
  
</html>