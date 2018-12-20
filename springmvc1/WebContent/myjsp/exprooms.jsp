<%@page import="javax.servlet.http.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
	  	<h2>Rooms</h2>
          <div class="table-responsive">
            <table class="table table-striped table-sm">
              <thead>
                <tr>
                  <th>ID</th>
                  <th>Room</th>
                  <th>Function</th>
                </tr>
              </thead>
              <tbody>
				<c:forEach items="${sessionScope.rlist}" var="r">
          			<tr>
						<td>${r.id}</td>
             		<td><a class="nav-link" href="selectroom/${r.room}" onclick="getRoomContent()"><h5>${r.room}</h5></a></td>
             			<td><a href="deleteroom/${r.id}">Delete</a></td>
           			</tr>
       			</c:forEach>
              </tbody>
              <tfoot>
              	<button class="open-button" onclick="openForm()">Add Room</button>
              </tfoot>
            </table>
          </div>
          
          
          <div class="form-popup" id="myForm">
			<form action="addRoom" method="post" class="form-container">
			    <h1>Add new Room</h1>
				<input type="text" value="0" name="id" readonly>
				<input type="text" placeholder="Enter Name" name="room" required>
				<input type="hidden"  name="state" value="1">
			
			    <button type="submit" class="btn">Add</button>
			    <button type="button" class="btn cancel" onclick="closeForm()">Close</button>
			  </form>
		</div>
	    <script>
	
        function getRoomContent(){
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
  
          
  
