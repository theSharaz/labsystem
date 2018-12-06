<%@page import="entity.Class"%>
<%@page import="javax.servlet.http.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
	  	<h2>Classes</h2>
          <div class="table-responsive">
            <table  class="table table-striped table-sm">
              <thead>
                <tr>
                  <th><a class="nav-link" href="#" onclick="getPages()">sdsad</a></th>
                  <th>Name</th>
                </tr>
              </thead>
              <tbody>
				<c:forEach items="${sessionScope.clist}" var="cl">
          			<tr>
						<td>${cl.classno}</td>
             			<td><a class="nav-link" href="#" onclick="getPages()">${cl.name}</a></td>
           			</tr>
           			
       			</c:forEach>
              </tbody>
            </table>
          </div>
 
          

          
  
