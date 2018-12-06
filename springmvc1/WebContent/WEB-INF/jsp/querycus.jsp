<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="../js/jquery-3.3.1.js"></script>
	<script type="text/javascript"></script>
	
	<link  href="../css/lecss.css" rel="stylesheet" type="text/css">
	

  </head>
  
  <body>
  	<div class="container">
      <table id="latab" class="table table-dark">
        <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Name</th>
      <th scope="col">Phone</th>
      <th scope="col">Delete</th>
    </tr>
  </thead>
       <c:forEach items="${clist}" var="cus">
          <tr>
             <td>${cus.id}</td>
             <td>${cus.name}</td>
             <td>${cus.phone}</td>
             <td><a href="delete/${cus.id}">Delete</a></td>
           </tr>
       </c:forEach>
    </table>
    
    <button type="button" class="btn btn-dark" onclick="click()">Dark</button>
   
   <button class="open-button" onclick="openForm()">Open Form</button>

<div class="form-popup" id="myForm">
  <form action="" class="form-container">
    <h1>Login</h1>

    <label for="email"><b>Email</b></label>
    <input type="text" placeholder="Enter Email" name="email" required>

    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="psw" required>

    <button type="submit" class="btn">Login</button>
    <button type="button" class="btn cancel" onclick="closeForm()">Close</button>
  </form>
</div>

<!--   		<div id="contzzz">
  		
  		</div>
       	<script type="text/javascript" src="../js/jquery-3.3.1.js"></script>
         <script src="../js/general.js"></script> -->

   
   
    </div>
    
    <script>

    
    function openForm() {
        document.getElementById("myForm").style.display = "block";
    }

    function closeForm() {
        document.getElementById("myForm").style.display = "none";
    }
    
     	function click(){
    		$('#latab').load('/load');
    	}
  
    </script>
  </body>
  
</html>
