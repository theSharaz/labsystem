<%@page import="javax.servlet.http.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<!-- Optional theme 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">-->




  <h2>Users</h2>
  <ul class="nav nav-pills">
    <li class="active noround"><a data-toggle="pill" href="#prof">Applications</a></li>
    <li class="noround"><a data-toggle="pill" href="#stu">Approved Times</a></li>
  </ul>
  
  	  	


  <div class="tab-content">
    <div id="prof" class="tab-pane fade in active">
 
	  	<h2>Professor</h2>
          <div class="table-responsive">
            <table class="table table-striped table-sm table-hover">
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
             			<td><a href="deleteprof/${p.profnum}" onclick="getStudents()">Delete</a></td>
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
			
			    <button type="submit" class="btn" onclick="getStudents()">Add</button>
			    <button type="button" class="btn cancel" onclick="closeForm()">Close</button>
			  </form>
		</div>
    </div>
    
    <div id="stu" class="tab-pane fade in active">
 
	  	<h2>Students</h2>
          <div>
	      <table class="table table-bordered table-striped table-hover">
	        <thead>
	          <tr class="table-head">
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
             			<td><a href="deletestu/${s.stuNum}" onclick="getStudents()">Delete</a></td>
           			</tr>
       			</c:forEach>
              </tbody>
              <tfoot>
              	<button class="open-button" onclick="openForm1()">Add Student</button>
              </tfoot>
            </table>
          </div>
          
          
          <div class="form-popup" id="myForm1">
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
			
			    <button type="submit" onclick="getStudents()" class="btn">Add</button>
			    <button type="button" class="btn cancel" onclick="closeForm1()">Close</button>
			  </form>
		</div>
    </div>


    
  </div>

	    <script>
	
	       function getStudents(){
	        	  setTimeout(function(){
	                	$("#cont").load('../myjsp/students.jsp');
	            		return false;
	            		},
	            		500);
	          }
	    function openForm() {
	        document.getElementById("myForm").style.display = "block";
	    }
	
	    function closeForm() {
	        document.getElementById("myForm").style.display = "none";
	    }
	    
	    function openForm1() {
	        document.getElementById("myForm1").style.display = "block";
	    }
	
	    function closeForm1() {
	        document.getElementById("myForm1").style.display = "none";
	    }
	    </script>
	    
	   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
