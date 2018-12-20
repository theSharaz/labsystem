<%@page import="javax.servlet.http.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
			<form action="applyTime" method="post" class="form-container">
			    <h1>Book Time</h1>
				<input type="text" value="0" name="appid" readonly>
			  	<select name="classno">
					<c:forEach items="${sessionScope.sclist}" var="sc">
						<option value="${sc.classno}">${sc.name}</option>
					</c:forEach>
			  	</select>					
			  	<input type="text"  name="stunum"  value="${sessionScope.stud.stuNum}" readonly>
			  	<input type="text"  name="week"  value="${sessionScope.avtime.week}" readonly>
			  	<input type="text"  name="day"  value="${sessionScope.avtime.day}" readonly>
			  	<input type="text"  name="start"  value="${sessionScope.avtime.start}" readonly>
			  	<input type="text"  name="finish"  value="${sessionScope.avtime.finish}" readonly>			  	
				<input type="text"  name="room" value="${sessionScope.avtime.room}">		  	
				<input type="hidden"  name="availableid" value="${sessionScope.avtime.availableid}">
			    <button type="submit" class="btn" onclick="getOpenExp()">Add</button>
			    <button type="button" class="btn cancel" onclick="closeForm()">Close</button>
			  </form>
			  
			  
			  
			  	    <script>
	
	       function getOpenExp(){
	        	  setTimeout(function(){
	                	$("#stucont").load('../stujsp/openExp.jsp');
	            		return false;
	            		},
	            		800);
	          }
	    </script>