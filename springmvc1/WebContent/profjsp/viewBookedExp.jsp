<%@page import="javax.servlet.http.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
	  	<h2>Booked Exp</h2>
	  	
	  	          <div class="table-responsive">
            <table  class="table table-striped table-sm">
              <thead>
                <tr>
                  <th>ID no.</th>
                  <th>Class no.</th>
                  <th>Week no.</th>
                  <th>Day</th>
                  <th>Start</th>
                  <th>Finish</th>
                  <th>Room no.</th>
                </tr>
              </thead>
              <tbody>
				<c:forEach items="${sessionScope.belist}" var="be">
          			<tr>
						<td>${be.id}</td>
             			<td><a class="nav-link" href="#" onclick="getPage4()">${be.classno}</a></td>
						<td>${be.week}</td>
						<td>${be.day}</td>
						<td>${be.start}</td>
						<td>${be.finish}</td>
						<td>${be.room}</td>
           			</tr>
           			
       			</c:forEach>
              </tbody>
              <tfoot>
              	  	<button class="open-button" onclick="openForm()">Add Exp</button>
              </tfoot>
            </table>
          </div>
	  	
	  	
	  	
	  	<div class="form-popup" id="myForm">
			<form action="bookexp" method="post" class="form-container">
			    <h1>Add new Exp</h1>
				
				<input type=text name="id" value="0" readonly>
				<select name="classno">
					<c:forEach items="${sessionScope.pcllist}" var="c">
						<option value="${c.classno}">${c.classno}</option>
					</c:forEach>
			  	</select>
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
						<option value="Period 8">Period 8</option>
			  	</select>
			  	<select name="finish">
						<option value="Period 1">Period 1</option>
						<option value="Period 2">Period 2</option>
						<option value="Period 3">Period 3</option>
						<option value="Period 4">Period 4</option>
						<option value="Period 5">Period 5</option>
						<option value="Period 6">Period 6</option>
						<option value="Period 7">Period 7</option>
						<option value="Period 8">Period 8</option>
			  	</select>
			  	<select name="room">
						<option value="Room 1">Room 1</option>
						<option value="Room 2">Room 2</option>

			  	</select>			  	
				<input type=text placeholder="Input Exp name" name="name">

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
	    function getPage4(){

			alert("BOOK");
	    	$("#profcont").load('../profjsp/viewExp.jsp');
			return false;
		}
	  
	    </script>