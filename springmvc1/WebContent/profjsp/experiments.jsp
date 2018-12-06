<%@page import="javax.servlet.http.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	  	<h2>Students</h2>
          <div class="table-responsive">
            <table class="table table-striped table-sm">
              <thead>
                <tr>
                  <th>#</th>
                  <th>Name</th>
                  <th>Stu No.</th>
                  <th>Class No.</th>
                </tr>
              </thead>
              <tbody>
				<c:forEach items="${sessionScope.elist}" var="e">
          			<tr>
						<td>${e.id}</td>
						<td>${e.name}</td>
						<td>${e.stuNum}</td>
						<td>${e.classno}</td>
           			</tr>
       			</c:forEach>
              </tbody>
            </table>
          </div>
 