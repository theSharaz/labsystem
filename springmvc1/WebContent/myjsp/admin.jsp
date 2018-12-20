
<%@page import="javax.servlet.http.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

	  		 <h2>ADMIN</h2>

<div class="card" style="width: 18rem;">
  <div class="card-body">
    <h5 class="card-title">Hello ${sessionScope.admin.name}</h5>
    <h6 class="card-subtitle mb-2 text-muted">ID no. ${sessionScope.admin.id}</h6>
    <p class="card-text">This user has all the admin privileges.</p>
</div>


</div>


	<p>
		<h2>Please read and understand the Admin privileges.</h2> <br>
		<br>
		<h2>Admin Privileges:</h2> <br>
		<br>
		<h2>1) Student Appointment Information Auditor</h2> <br>
		<br>
		<h2>2) Open Laboratory Manager</h2> <br>
	</p>
	
		<button class="open-button" onclick="openForm()">Change Password</button>
			
		 <div class="form-popup" id="myForm">
			<form action="changePass" method="post" class="form-container">
			    <h1>Change Password</h1>				
				<input type="text" value="${sessionScope.admin.id}" name="id" readonly>
				<input type="hidden" value="${sessionScope.admin.name}" name="name">
				<input type="password" placeholder="Enter old password"  name="password">
				<input type="password" placeholder="Enter new password" name="newpassword">
				
			    <button type="submit" class="btn">Change</button>
			    <button type="button" class="btn cancel" onclick="closeForm()">Close</button>
			  </form>
		</div>
		
		<script>
	    
	    function openForm() {
	        document.getElementById("myForm").style.display = "block";
	    }
	
	    function closeForm() {
	        document.getElementById("myForm").style.display = "none";
	    }
	  
	    </script>
