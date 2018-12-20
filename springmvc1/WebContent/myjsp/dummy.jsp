<%@page import="javax.servlet.http.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<!-- Optional theme 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">-->




  <h2>Bookings</h2>
  <ul class="nav nav-pills">
    <li class="active noround"><a data-toggle="pill" href="#app">Applications</a></li>
    <li class="noround"><a data-toggle="pill" href="#approved">Approved Times</a></li>
  </ul>
  
  	  	
		<form action="filterBook" method="post" class="form-inline">
		  <div class="form-group mb-2">		    
			  	<select name="classno">
					<option disabled selected value> -- select an option -- </option>
					<c:forEach items="${sessionScope.clist}" var="c">
						<option value="${c.classno}">${c.name}</option>
					</c:forEach>
			  	</select>			    
		  </div>
		  <div class="form-group mx-sm-3 mb-2 bg-light">
		  	<select name="week">
				<option disabled selected value> -- select an option -- </option>
				<option value="week 1">week 1</option>
				<option value="week 2">week 2</option>
				<option value="week 3">week 3</option>
				<option value="week 4">week 4</option>
				<option value="week 5">week 5</option>
				<option value="week 6">week 6</option>
				<option value="week 7">week 7</option>
				<option value="week 8">week 8</option>
		  	</select>
		  </div>
		  <button type="submit" onclick="getBookings()" class="btn btn-primary mb-2">Confirm identity</button>
		</form>	

  <div class="tab-content">
    <div id="app" class="tab-pane fade in active">
 
      <h3>Applications</h3>
      <table class="table table-striped bg-light">
        <thead>
          <tr class="table-head bg-light">
            <th>Stu #</th>
            <th>Classno</th>
            <th>Week</th>
            <th>Day</th>
            <th>start</th>
            <th>Finish</th>
            <th>Room</th>
            <th>Function</th>
          </tr>
        </thead>
		              <tbody>
				<c:forEach items="${sessionScope.aplist}" var="a">
          			<tr>
						<td>${a.stunum}</td>
						<td>${a.classno}</td>
						<td>${a.week}</td>
             			<td>${a.day}</td>
             			<td>${a.start}</td>
             			<td>${a.finish}</td>
             			<td>${a.room}</td>
             			<td><a href="approveAppliction/${a.availableid}" onclick="getBookings()">Accept</a>
             				<a href="rejectAppliction/${a.availableid}" onclick="getBookings()">Reject</a></td>
           			</tr>
       			</c:forEach>
              </tbody>
      </table>
    </div>
    
    <div id="approved" class="tab-pane fade in active">
 
      <h3>Approved Time</h3>
      <table class="table  table-striped  bg-light">
        <thead>
          <tr class="table-head bg-light">
            <th>Stu #</th>
            <th>Classno</th>
            <th>Week</th>
            <th>Day</th>
            <th>start</th>
            <th>Finish</th>
            <th>Room</th>
            <th>Function</th>
          </tr>
        </thead>
		              <tbody>
				<c:forEach items="${sessionScope.atlist}" var="a">
          			<tr>
						<td>${a.stunum}</td>
						<td>${a.classno}</td>
						<td>${a.week}</td>
             			<td>${a.day}</td>
             			<td>${a.start}</td>
             			<td>${a.finish}</td>
             			<td>${a.room}</td>
             			<td><a href="removeApproved/${a.approvedid}" onclick="getBookings()">Accept</a></td>
           			</tr>
       			</c:forEach>
              </tbody>
      </table>
    </div>


    
  </div>

	    <script>
	
	       function getBookings(){
	        	  setTimeout(function(){
	                	$("#cont").load('../myjsp/bookings.jsp');
	            		return false;
	            		},
	            		500);
	          }
	    </script>
	    
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
