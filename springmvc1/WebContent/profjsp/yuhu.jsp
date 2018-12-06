<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

     <h1 style="color:red">Yuhu ${pid} !</h1>

          <div class="table-responsive">
            <table  class="table table-striped table-sm">
              <thead>
                <tr>
                  <th>Class no.</th>
                  <th>Prof no.</th>
                </tr>
              </thead>
              <tbody>
				<c:forEach items="${sessionScope.pclist}" var="pc">
          			<tr>
						<td>${pc.classno}</td>
             			<td>${pc.profnum}</td>
           			</tr>
           			
       			</c:forEach>
              </tbody>
            </table>
          </div>