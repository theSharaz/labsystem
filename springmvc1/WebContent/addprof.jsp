<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   	<link  href="css/lecss.css" rel="stylesheet" type="text/css">
   
  </head>
  
  <body>
  <form action="admin/addProf" method="post" class="form-container">
    <h1>Add new Professor</h1>
	
	<input type=text name="id" value="0" readonly>
	<input type="text" placeholder="Enter Name" name="name" required>
	<input type="password" placeholder="Enter Password" name="password" required>
	<select name="deptno">
	    <option value="001">Computer</option>
	    <option value="002">Art</option>
	    <option value="003">Languages</option>
  	</select>
    <input type="text" placeholder="Enter Address" name="address" required>
    <input type="text" placeholder="Enter Email" name="email" required>
    <input type="text" placeholder="Enter Phone" name="phone" required>

    <button type="submit" class="btn">Add</button>
    <button type="button" class="btn cancel" onclick="closeForm()">Close</button>
  </form>
  </body>
</html>
