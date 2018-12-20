<%@page import="javax.servlet.http.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
	  	<h2>Booked Exp</h2>
	  	
         <div class="table-responsive">
	      <table class="table table-bordered table-striped table-hover">
	        <thead>
	          <tr class="table-head"> 
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
              </tfoot>
            </table>
          </div>
	  	
	  	
	    <script>
	    function getPage4(){

			alert("BOOK");
	    	$("#stucont").load('../stujsp/viewExp.jsp');
			return false;
		}
	  
	    </script>