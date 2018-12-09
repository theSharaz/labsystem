<%@page import="javax.servlet.http.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	  	<h2>Students</h2>
  <%--         <div class="table-responsive">
            <table class="table table-striped table-sm">
              <thead>
                <tr>
                  <th>Name</th>
                </tr>
              </thead>
              <tbody>
				<c:forEach items="${sessionScope.nlist}" var="name">
          			<tr>
						<td>${name}</td>
           			</tr>
       			</c:forEach>
              </tbody>
            </table>
          </div>
  --%>
  

	  	<h2>My Timetable</h2>
	  	
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
             			<td>${be.classno}</td>
						<td>${be.week}</td>
						<td>${be.day}</td>
						<td>${be.start}</td>
						<td>${be.finish}</td>
						<td>${be.room}</td>
           			</tr>
           			
       			</c:forEach>
              </tbody>
            </table>
          </div>
	  	
	    <script>

	    
	    </script>