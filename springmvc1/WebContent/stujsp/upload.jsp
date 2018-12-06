<%@page import="javax.servlet.http.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<h3>Upload page</h3> 
<form action="addfile" method="post" enctype="multipart/form-data">  
     <input type="text" name="id" value="1" />
     <input type="text" name="name" />
     <input type="file" name="mfile" /> 
     <input type="text" name="stuNum" value="${sessionScope.stud.stuNum}" readonly>
     <input type="text" name="classno" value="${sessionScope.stud.classno}" readonly>
     <input type="text" name="state" value="1" />     
     <input type="submit" value="Submit" />
 </form>  
