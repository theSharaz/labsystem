<%@page import="entity.Class"%>
<%@page import="javax.servlet.http.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
	  	<h2>Classes</h2>
          <div class="table-responsive">
            <table  class="table table-striped table-sm">
              <thead>
                <tr>
                  <th>Class no.</th>
                  <th>Name</th>
                </tr>
              </thead>
              <tbody>
				<c:forEach items="${sessionScope.clist}" var="cl">
          			<tr>
						<td>${cl.classno}</td>
             			<td><a class="nav-link" href="#" onclick="getPages()"><h5>${cl.name}</h5></a></td>
           			</tr>
           			
       			</c:forEach>
              </tbody>
				<tfoot>
				   <button class="open-button" onclick="openForm()">Add New Course</button>
				</tfoot>              
            </table>
          </div>
 		
 				<div class="form-popup" id="myForm">
			<form action="addClass" method="post" class="form-container">
			    <h1>New Class</h1>
				
				<input type=text name="classno" value="0" readonly>
				<input type="text" placeholder="Enter Name" name="name" required>
			    <button type="submit" class="btn">Add</button>
			    <button type="button" class="btn cancel" onclick="closeForm()">Close</button>
			  </form>
		</div>
          

          
  
