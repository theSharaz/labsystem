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
  

	  	<h2>My Exp</h2>
	  	
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
              <tfoot>
				<button class="open-button" onclick="openForm()">Upload Exp</button>
              </tfoot>
            </table>
          </div>
	  	
	  	<div class="form-popup" id="myForm">			    				
			<form action="upload" method="post" class="form-container" enctype="multipart/form-data">  
			    <h1>Upload Exp</h1>
			     <input type="text" name="name" />
			     <input type="file" name="file" /> 
			     <input type="submit" value="Submit" />
 			</form>  
		</div>
	  	
	    <script>
	    function getPage4(){

	        function openForm() {
		        document.getElementById("myForm").style.display = "block";
		    }
		
		    function closeForm() {
		        document.getElementById("myForm").style.display = "none";
		    }
			alert("BOOK");
	    	$("#profcont").load('../stujsp/viewExp.jsp');
			return false;
		}
	  
	    </script>