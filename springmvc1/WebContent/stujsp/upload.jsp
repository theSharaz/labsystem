<%@page import="javax.servlet.http.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

${sessionScope.fil.id}
          <div id="myForm">

			<h3>Upload page</h3> 
			
			<form action="uploadfile" method="post" enctype="multipart/form-data" >  
			     <input type="text" name="id" value="${sessionScope.fil.id}" readonly/>
			     <input type="text" name="name" value="${sessionScope.fil.name}" readonly/>
			     <input type="text" name="stuNum" value="${sessionScope.fil.stuNum}" readonly>
			     <input type="text" name="classno" value="${sessionScope.fil.classno}" readonly>
			     <input type="hidden" name="state" value="1" />    
			     <input type="file" name="file" /> 
			      
			    <button type="submit" class="btn">Add</button>
			 </form>  
		</div>
			 