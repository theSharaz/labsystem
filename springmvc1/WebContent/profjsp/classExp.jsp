<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

     <h1 style="color:red">Book Experiment ${pid} !</h1>
     
     

          <div class="table-responsive">
            <table  class="table table-striped table-sm">
              <thead>
              <a class="nav-link" href="#" onclick="getPage2()">Book Experiment</a>
                <tr>
                  <th>Class no.</th>
                  <th>Prof no.</th>
                </tr>
              </thead>
              <tbody>
				<c:forEach items="${sessionScope.pcllist}" var="pc">
          			<tr>
						<td>${pc.classno}</td>
             			<td>Details</td>
           			</tr>
           			
       			</c:forEach>
              </tbody>
              <tfoot><a class="nav-link" href="#" onclick="getPage1()">View Booked Experiment</a>
              </tfoot>
            </table>
          </div>
          

	    <script>
	    
	    function getPage2(){

			alert("BOOK");
	    	$("#profcont").load('../profjsp/bookexp.jsp');
			return false;
		}
	    
	    function getPage1(){

			alert("BOOKED");
	    	$("#profcont").load('../profjsp/viewBookedExp.jsp');
			return false;
		}
	  
	    </script>