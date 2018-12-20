<%@page import="dao.ProfessorDao"%>
<%@page import="javax.servlet.http.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container pb-cmnt-container">
    <div class="row">
		<div class="w-100 h-75 p-3" style="background-color: #eee;">
            <div class="panel panel-info">
                <div class="panel-body">
                    <form action="addFeedback" method="GET" class="form-inline">
                    <input type="text" placeholder="Write your comment here!" class="w-100 h-75 pb-cmnt-textarea" name="comment">

                        <button class="btn btn-primary pull-right" onclick="getFeedback()" type="submit">POST</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

	    <script>
	
	       function getFeedback(){
	        	  setTimeout(function(){
	                	$("#cont").load('../myjsp/feedback.jsp');
	            		return false;
	            		},
	            		200);
	          }
	    </script>