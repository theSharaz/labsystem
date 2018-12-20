<%@page import="javax.servlet.http.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
	  	<h2>Feedback</h2>
          <div class="table-responsive">
            <table class="table table-striped table-sm">
              <thead>
                <tr>
                  <th>Comment</th>
                  <th>Time</th>
                </tr>
              </thead>
              <tbody>
				<c:forEach items="${sessionScope.fdlist}" var="f">
          			<tr>
						<td>${f.comment}</td>
             		<td><h5>${f.fdtime}</h5></td>
           			</tr>
       			</c:forEach>
              </tbody>
            </table>
          </div>