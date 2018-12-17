<%@page import="javax.servlet.http.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
	  	<h2>My Experiments</h2>
	  		
	  		${sessionScope.stud.name}
	  		
	  	  <div class="table-responsive">
            <table  class="table table-striped table-sm">
              <thead>
                <tr>
                  <th>Exp Name</th>
                  <th>Stu no.</th>
                  <th>State no.</th>
                  <th>Upload</th>
                </tr>
              </thead>
              <tbody>
				<c:forEach items="${sessionScope.flist}" var="f">
          			<tr>
						<td>${f.name}</td>
						<td>${f.stuNum}</td>
						
				<c:set var = "status" value="You need to upload the experiment"/>
				<c:set var = "functon" value="Upload"/>										
				<c:set var = "down" value=""/>										
					<c:if test = "${f.state  eq 1}">
				<c:set var = "status" value="Experiment Uploaded"/>
				<c:set var = "functon" value="Re-Upload"/>
				<c:set var = "down" value="Download"/>										
					
				</c:if>	
									
						<td><h5>${status}</h5></td>
						<td>	<a href="fileupload/${f.id}" onclick="getupload()"><h5>${functon}</h5></a> <a href="download/${f.filename}"><h5>${down}</h5></a>	</td>
           			</tr>
           			
       			</c:forEach>
              </tbody>
            </table>
          </div>
	

	    <script>
	
	    
        function getupload(){
        	$("#stucont").load('../stujsp/upload.jsp');
      		return false;
      	}


	    </script>