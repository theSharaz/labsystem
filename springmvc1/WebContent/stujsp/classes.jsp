<%@page import="dao.ProfessorDao"%>
<%@page import="javax.servlet.http.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
	  	<h2>Classes</h2>
          <div class="table-responsive">
	      <table class="table table-bordered table-striped table-hover">
	        <thead>
	          <tr class="table-head"> 
                  <th>Stu No.</a></th>
                  <th>Class No.</th>
                </tr>
              </thead>
              <tbody>
				<c:forEach items="${sessionScope.sclist}" var="scl">
          			<tr>
             			<td>${scl.classno}</td>          			
             			<td><a class="nav-link" href="selectclass/${scl.classno}" onclick="getviewBookedExp()">${scl.name}</a></td>
           			</tr>
           			
       			</c:forEach>
              </tbody>
            </table>
          </div>
          
          
          <script>
          
          function getviewBookedExp(){
          	$("#stucont").load('../stujsp/viewBookedExp.jsp');
      		return false;
      	}
          
          </script>
 		
          

          
  
