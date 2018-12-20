<%@page import="javax.servlet.http.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<h3>Student home page</h3>


<div class="card" style="width: 30rem;">
  <div class="card-body">
    <h5 class="card-title">Hello ${sessionScope.stud.name}</h5>
    <h6 class="card-subtitle mb-2 text-muted"><strong>Student No: </strong>${sessionScope.stud.stuNum}</h6>
    <p class="card-text"><strong>Class No: </strong>${sessionScope.stud.classno}</p>
    <p class="card-text"><strong>Address No: </strong>${sessionScope.stud.address}</p>
    <p class="card-text"><strong>Email: </strong>${sessionScope.stud.email}</p>
    <p class="card-text"><strong>Phone No: </strong>${sessionScope.stud.phone}</p>    
</div>

</div>
<%-- <div class="container">
	<div class="row">
		<div class="col-md-offset-10 col-md-8 col-lg-offset-3 col-lg-6">
    	 <div class="well profile">
            <div class="col-sm-12">
                <div class="col-xs-12 col-sm-8">
                    <h2>Hello ${sessionScope.stud.name}</h2>
                    <p><strong>Student No: </strong>${sessionScope.stud.stuNum}</p>
                    <p><strong>Class No: </strong>${sessionScope.stud.classno}</p>
                    <p><strong>Address No: </strong>${sessionScope.stud.address}</p>
                    <p><strong>Email: </strong>${sessionScope.stud.email}</p>
                    <p><strong>Phone No: </strong>${sessionScope.stud.phone}</p>
                </div>             
            </div>            
    	 </div>                 
		</div>
	</div>
</div> --%>

	<p>
		<h2>Please read and understand student user privileges.</h2> <br>
		<br>
		<h2>Student Guide:</h2> <br>
		<br>
		<h2>1) If you are not attending class bookd experiments please make sure you make your own booking</h2> <br>
		<br>
		<h2>2) When you make a booking application please make sure to check whether the time has been approved or not</h2> <br>
		<br>
		<h2>3) When you upload experiments make sure they are in PDF format</h2> <br>
		<br>		

	</p>
		<button class="open-button" onclick="openForm()">Change Password</button>
			
		 <div class="form-popup" id="myForm">
			<form action="changePass" method="post" class="form-container">
			    <h1>Change Password</h1>				
				<input type="text" value="${sessionScope.stud.stuNum}" name="stunum" readonly>
				<input type="hidden" value="${sessionScope.stud.name}" name="name">
				<input type="password" placeholder="Enter old password"  name="password">
				<input type="hidden" value="${sessionScope.stud.classno}" name="classno">
			    <input type="hidden" value="${sessionScope.stud.address}" name="address" >
			    <input type="hidden" value="${sessionScope.stud.email}" name="email" >
			    <input type="hidden" value="${sessionScope.stud.phone}" name="phone" >
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