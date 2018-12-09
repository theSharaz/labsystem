<%@page import="javax.servlet.http.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	  	<h2>Your Classes</h2>
          <div class="table-responsive">
            <table class="table table-striped table-sm">
              <thead>
                <tr>
                  <th>Class No.</th>
                </tr>
              </thead>
              <tbody>
				<c:forEach items="${sessionScope.pcllist}" var="pcl">
          			<tr>
             			<td><a class="nav-link" href="getclassexp/${pcl.classno}" onclick="getclassExp()"><h5>${pcl.classno}</h5></a></td>
           			</tr>
       			</c:forEach>
              </tbody>
            </table>
          </div>
 
           <script>
          
          function getclassExp(){
          	$("#profcont").load('../profjsp/classExp.jsp');
      		return false;
      	}
          
          </script>