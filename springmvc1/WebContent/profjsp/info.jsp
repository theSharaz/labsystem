<%@page import="javax.servlet.http.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<h3>Professor home page</h3>



<%-- <div class="container">
	<div class="row">
		<div class="col-md-offset-10 col-md-8 col-lg-offset-3 col-lg-6">
    	 <div class="well profile">
            <div class="col-sm-12">
                <div class="col-xs-12 col-sm-8">
                    <h2>Hello Professor ${sessionScope.profe.name}</h2>
                    <p><strong>Professor No: </strong>${sessionScope.profe.profnum}</p>
                    <p><strong>Address No: </strong>${sessionScope.profe.address}</p>
                    <p><strong>Email: </strong>${sessionScope.profe.email}</p>
                    <p><strong>Phone No: </strong>${sessionScope.profe.phone}</p>
                </div>             
            </div>            
    	 </div>                 
		</div>
	</div>
</div> --%>

<div class="card" style="width: 30rem;">
  <div class="card-body">
    <h5 class="card-title">Hello Professor ${sessionScope.profe.name}</h5>
    <h6 class="card-subtitle mb-2 text-muted"><strong>Professor No: </strong>${sessionScope.profe.profnum}</h6>
        <p><strong>Address No: </strong>${sessionScope.profe.address}</p>
        <p><strong>Email: </strong>${sessionScope.profe.email}</p>
        <p><strong>Phone No: </strong>${sessionScope.profe.phone}</p>   
</div>

</div>
		<button class="open-button" onclick="openForm()">Change Password</button>
			
		 <div class="form-popup" id="myForm">
			<form action="changePass" method="post" class="form-container">
			    <h1>Change Password</h1>
				<input type="text" value="${sessionScope.profe.profnum}" name="profnum" readonly>
				<input type="hidden" value="${sessionScope.profe.name}" name="name">
				<input type="password" placeholder="Enter old password"  name="password">
			    <input type="hidden" value="${sessionScope.profe.address}" name="address" >
			    <input type="hidden" value="${sessionScope.profe.email}" name="email" >
			    <input type="hidden" value="${sessionScope.profe.phone}" name="phone" >
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