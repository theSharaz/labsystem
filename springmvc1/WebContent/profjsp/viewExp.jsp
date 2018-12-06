<%@page import="javax.servlet.http.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
	  	<h2>Booked Exp</h2>
	  	
	  	          <div class="table-responsive">
            <table  class="table table-striped table-sm">
              <thead>
                <tr>
                  <th>Class no.</th>
                  <th>Prof no.</th>
                </tr>
              </thead>
              <tbody>
				<c:forEach items="${sessionScope.pcllist}" var="pc">
          			<tr>
						<td>${pc.classno}</td>
             			<td>Details</td>
           			</tr>
           			
       			</c:forEach>
              </tbody>
              <tfoot>
              	  	<button class="open-button" onclick="openForm()">Add Exp</button>
              </tfoot>
            </table>
          </div>
	  	
	  	
	  	
	  	<div class="form-popup" id="myForm">
			<form action="addProf" method="post" class="form-container">
			    <h1>Add new Exp</h1>
				
				<input type=text name="profnum" value="0" readonly>
				<input type="text" placeholder="Enter Name" name="name" required>
				<input type="password" placeholder="Enter Password" name="password" required>
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