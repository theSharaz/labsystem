<%@page import="javax.servlet.http.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
	  	<h2>Room :${sessionScope.roomid}</h2>
          <div class="table-responsive">
	      <table class="table table-bordered table-striped table-hover">
	        <thead>
	          <tr class="table-head">     
                  <th>Week</th>
                  <th>Day</th>
                  <th>start</th>
                  <th>Finish</th>
                  <th>Room</th>
                  <th>Function</th>
                </tr>
              </thead>
              <tbody>
				<c:forEach items="${sessionScope.avlist}" var="a">
          			<tr>
						<td>${a.week}</td>
             			<td>${a.day}</td>
             			<td>${a.start}</td>
             			<td>${a.finish}</td>
             			<td>${a.room}</td>
             			<td><a href="deleteAvTime/${a.availableid}" onclick="getRoom()">Delete</a></td>
           			</tr>
       			</c:forEach>
              </tbody>
              <tfoot>
              	<button class="open-button" onclick="openForm()">Add Open Time</button>
              </tfoot>
            </table>
          </div>
          
          
          <div class="form-popup" id="myForm">
			<form action="addAvTime" method="post" class="form-container">
			    <h1>Add new Open Time</h1>
				<input type="text" value="0" name="availableid" readonly>
			  	<select name="week">
						<option value="week 1">week 1</option>
						<option value="week 2">week 2</option>
						<option value="week 3">week 3</option>
						<option value="week 4">week 4</option>
						<option value="week 5">week 5</option>
						<option value="week 6">week 6</option>
						<option value="week 7">week 7</option>
						<option value="week 8">week 8</option>
			  	</select>
			  	<select name="day">
						<option value="Monday">Monday</option>
						<option value="Tuesday">Tuesday</option>
						<option value="Wednesday">Wednesday</option>
						<option value="Thursday">Thursday</option>
						<option value="Friday">Friday</option>
			  	</select>
			  	<select name="start">
						<option value="Period 1">Period 1</option>
						<option value="Period 2">Period 2</option>
						<option value="Period 3">Period 3</option>
						<option value="Period 4">Period 4</option>
						<option value="Period 5">Period 5</option>
						<option value="Period 6">Period 6</option>
						<option value="Period 7">Period 7</option>
			  	</select>
			  	<select name="finish">
						<option value="Period 2">Period 2</option>
						<option value="Period 3">Period 3</option>
						<option value="Period 4">Period 4</option>
						<option value="Period 5">Period 5</option>
						<option value="Period 6">Period 6</option>
						<option value="Period 7">Period 7</option>
						<option value="Period 8">Period 8</option>
			  	</select>
				<input type="text"  name="room" value="${sessionScope.roomid}">		  	
				<input type="hidden"  name="state" value="1">
			    <button type="submit" class="btn" onclick="getRoom()">Add</button>
			    <button type="button" class="btn cancel" onclick="closeForm()">Close</button>
			  </form>
		</div>
	    <script>
	
	       function getRoom(){
	        	  setTimeout(function(){
                	$("#cont").load('../myjsp/roomcontent.jsp');
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
	  
	    </script>
  
          
  
