<%@page import="javax.servlet.http.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
	
     <h1 style="color:red"> Class :${sessionScope.clas.name} Class no: ${sessionScope.clas.classno} </h1>
       <div class="col-xs-6">
		<h2 class="sub-header">Professor and Students</h2>    
          <div class="table-responsive">
            <table  class="table table-striped table-sm">
              <thead>
                <tr colspan="2">
                 <h4>Professor: ${sessionScope.prof.profnum} 
                 Professor's Name: ${sessionScope.prof.name}</h4>
                </tr>              
                <tr>
                  <th>Student No.</th>
                  <th>Name</th>
                  <th>Password</th>
                  <th>Address</th>
                  <th>Email</th>
                  <th>Phone</th>
                </tr>
              </thead>
              <tbody>
				<c:forEach items="${sessionScope.stlist}" var="s">
          			<tr>
						<td>${s.stuNum}</td>
             			<td>${s.name}</td>
             			<td>${s.password}</td>
             			<td>${s.address}</td>
             			<td>${s.email}</td>
             			<td>${s.phone}</td>
           			</tr>
       			</c:forEach>
				<tfoot>
				   <button class="open-button" onclick="openForm()">Add Student</button>
				</tfoot>        			
              </tbody>
            </table>          
          </div>
        </div>
          
          
 		<div class="form-popup" id="myForm">
			<form action="addStuClass" method="post" class="form-container">
			    <h1>Add Student to Class</h1>
				<input type="hidden" name="id" value="0" readonly>
			    				
				<input type="text" name="classno" value="${sessionScope.clas.classno}" readonly>
				<select name="stunum">
					<c:forEach items="${sessionScope.sslist}" var="c">
						<option value="${c.stuNum}">${c.stuNum}</option>
					</c:forEach>					
			  	</select>			    
			  	<button type="submit" class="btn" onclick="getClassContent()">Add</button>
			    <button type="button" class="btn cancel" onclick="closeForm()">Close</button>
			  </form>
		</div>            
          
       <div class="col-xs-6">
		<h2 class="sub-header">Timetable</h2>            
          <div class="table-responsive">
            <table  class="table table-striped table-sm">
              <thead>
                <tr>
                  <th>ID no.</th>
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
         </div>

       <div class="col-xs-6">
		<h2 class="sub-header">Experiments</h2>          
          <div class="table-responsive">
            <table  class="table table-striped table-sm">
              <thead>
                <tr>
                  <th>Student no.</th>
                  <th>Experiment name</th>
                  <th>State</th>
                  <th>Action</th>
                  
                </tr>
              </thead>
              <tbody>
				<c:forEach items="${sessionScope.flist}" var="f">
				
				<c:set var = "status" value="Not yet uploaded"/>
				<c:set var = "functon" value=""/>										
					<c:if test = "${f.state  eq 1}">
				<c:set var = "functon" value="Download"/>
				<c:set var = "status" value="Uploaded"/>
					
				</c:if>
          			<tr>
						<td>${f.stuNum}</td>
						<td>${f.name}</td>
						<td>${status}</td>
						<td>	<a href="download/${f.filename}"><h5>${functon}</h5></a>	</td>
           			</tr>
           			
       			</c:forEach>
              </tbody>

            </table>
          </div> 
        </div> 
          
          

	    <script>
	    
        function getClassContent(){
      	  setTimeout(function(){
              	$("#cont").load('../myjsp/classcontent.jsp');
          		return false;
          		},
          		200);
        }
        
        
	    function openForm() {
	        document.getElementById("myForm").style.display = "block";
	    }
	
	    function closeForm() {
	        document.getElementById("myForm").style.display = "none";
	    }

	    </script>