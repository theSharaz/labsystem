<%@page import="javax.servlet.http.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
	
     <h1 style="color:red">Class Experiments</h1>
     
     

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
          

	    <script>
	    

	    </script>