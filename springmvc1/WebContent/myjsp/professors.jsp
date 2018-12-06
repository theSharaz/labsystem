<%@page import="javax.servlet.http.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
	  	<h2>Professor</h2>
          <div class="table-responsive">
            <table class="table table-striped table-sm">
              <thead>
                <tr>
                  <th>Prof No.</th>
                  <th>Name</th>
                  <th>Password</th>
                  <th>Address</th>
                  <th>Email</th>
                  <th>Phone</th>
                  <th>Delete</th>
                </tr>
              </thead>
              <tbody>
				<c:forEach items="${sessionScope.plist}" var="p">
          			<tr>
						<td>${p.profnum}</td>
             			<td>${p.name}</td>
             			<td>${p.password}</td>
             			<td>${p.address}</td>
             			<td>${p.email}</td>
             			<td>${p.phone}</td>
             			<td><a href="deleteprof/${p.profnum}">Delete</a></td>
					</tr>
       			</c:forEach>
				</tbody>
				<tfoot>
				   <button class="open-button" onclick="openForm()">Add Professor</button>
				</tfoot>
            </table>
          </div>
          
		<div class="form-popup" id="myForm">
			<form action="addProf" method="post" class="form-container">
			    <h1>Add new Professor</h1>
				
				<input type=text name="profnum" value="0" readonly>
				<input type="text" placeholder="Enter Name" name="name" required>
				<input type="password" placeholder="Enter Password" name="password" required>
			    <input type="text" placeholder="Enter Address" name="address" required>
			    <input type="text" placeholder="Enter Email" name="email" required>
			    <input type="text" placeholder="Enter Phone" name="phone" required>
			
			    <button type="submit" class="btn">Add</button>
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
  
