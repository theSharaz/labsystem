<%@page import="javax.servlet.http.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
	  	<h2>Professor</h2>
          <div class="table-responsive">
            <table class="table table-striped table-sm">
              <thead>
                <tr>
                  <th>#</th>
                  <th>Name</th>
                  <th>Password</th>
                  <th>DeptNo</th>
                  <th>Address</th>
                  <th>Email</th>
                  <th>Phone</th>
                  <th>Delete</th>
                </tr>
              </thead>
              <tbody>
				<c:forEach items="${sessionScope.plist}" var="p">
          			<tr>
						<td>${p.id}</td>
             			<td>${p.name}</td>
             			<td>${p.password}</td>
             			<td>${p.deptno}</td>
             			<td>${p.address}</td>
             			<td>${p.email}</td>
             			<td>${p.phone}</td>
             			<td><a href="deleteprof/${p.id}">Delete</a></td>
					</tr>
       			</c:forEach>
				</tbody>
            </table>
          </div>