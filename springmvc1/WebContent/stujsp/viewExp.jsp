<%@page import="javax.servlet.http.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
	  	<h2>My Experiments</h2>
	  		
	  		
	  		
	  	  <div class="table-responsive">
            <table  class="table table-striped table-sm">
              <thead>
                <tr>
                  <th>ID no.</th>
                  <th>Exp Name</th>
                  <th>Stu no.</th>
                  <th>State no.</th>
                  <th>File</th>
                </tr>
              </thead>
              <tbody>
				<c:forEach items="${sessionScope.flist}" var="f">
          			<tr>
						<td>${f.id}</td>
						<td>${f.name}</td>
						<td>${f.stuNum}</td>
							<c:set var = "status" value="You need to upload the experiment"/>						
							<c:if test = "${f.state  eq 1}">
								<c:set var = "status" value="Experiment Uploaded"/>
							</c:if>	
									
						<td>${status}</td>
						<td>${f.file}</td>
           			</tr>
           			
       			</c:forEach>
              </tbody>
              <tfoot>
              	  	<button class="open-button" onclick="openForm()">Upload Exp</button>
              </tfoot>
            </table>
          </div>
	  	
	  	
	  	
	  	<div class="form-popup" id="myForm">
			<form action="addfile" method="post" class="form-container" enctype="multipart/form-data">  
			    <h1>Upload Exp</h1>
				
				     <input type="text" name="id" value="${f.id}" readonly/>
				     <input type="text" name="name" />
				     <input type="file" name="mfile" /> 
				     <input type="text" name="stuNum" value="${sessionScope.stud.stuNum}" readonly>
				     <input type="text" name="classno" value="${sessionScope.stud.classno}" readonly>
				     <input type="text" name="state" value="1" />     
				     <input type="submit" value="Submit" />
			
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