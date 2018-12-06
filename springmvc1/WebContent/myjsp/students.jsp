<%@page import="javax.servlet.http.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
	  	<h2>Students</h2>
          <div class="table-responsive">
            <table class="table table-striped table-sm">
              <thead>
                <tr>
                  <th>Student No.</th>
                  <th>Name</th>
                  <th>Password</th>
                  <th>Class No.</th>
                  <th>Address</th>
                  <th>Email</th>
                  <th>Phone</th>
                  <th>Delete</th>
                </tr>
              </thead>
              <tbody>
				<c:forEach items="${sessionScope.slist}" var="s">
          			<tr>
						<td>${s.stuNum}</td>
             			<td>${s.name}</td>
             			<td>${s.password}</td>
             			<td>${s.classno}</td>
             			<td>${s.address}</td>
             			<td>${s.email}</td>
             			<td>${s.phone}</td>
             			<td><a href="deletestu/${s.stuNum}">Delete</a></td>
           			</tr>
       			</c:forEach>
              </tbody>
              <tfoot>
              	<button class="open-button" onclick="openForm()">Add Student</button>
              </tfoot>
            </table>
          </div>
          
          
          <div class="form-popup" id="myForm">
			<form action="addStu" method="post" class="form-container">
			    <h1>Add new Student</h1>
				<input type="text" value="0" name="stunum" readonly>
				<input type="text" placeholder="Enter Name" name="name" required>
				<input type="password" placeholder="Enter Password" name="password" required>
				<select name="classno">
					<c:forEach items="${sessionScope.clist}" var="c">
						<option value="${c.classno}">${c.name}</option>
					</c:forEach>
			  	</select>
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
  
          
  
