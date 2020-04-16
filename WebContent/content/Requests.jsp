this is list of ${name} Requests
<%@page import="model.Requests"%>
<div class="w3-container">
  <h2>Striped Table</h2>
  <p>The w3-striped class adds zebra-stripes to a table:</p>

  <table class="w3-table w3-striped">
    <tr>
      <th>Item ID</th>
      <th>Borrower</th>
      <th>Period</th>
      <th>Request date</th>
      <th>Status</th>
      <th>Approve</th>
      <th>Deny</th>
      <th>Done</th>
    </tr>
    <tr>
      <td>Item ID</td>
      <td>Borrower</td>
      <td>Period</td>
      <td>Request date</td>
      <td>Status</td>
      <td>Approve</td>
      <td>Deny</td>
      <td>Done</td>
    </tr>
	      <%
		  Requests[] requests=(Requests[])request.getAttribute("requests");
		  for(int i=0;i<requests.length;i++) {
			    out.println("<tr>");
			    out.println("<td>"+requests[i].getItemID()+"</td>");
			    out.println("<td>"+requests[i].getBorrowerID()+"</td>");
			    out.println("<td>"+requests[i].getPeriod()+"</td>");
			    out.println("<td>"+requests[i].getDate()+"</td>");
			    out.println("<td>"+requests[i].getResponse()+"</td>");
			    if(requests[i].getResponse().equals("0")){
				    out.println("<td><a href='ApproveRequestServlet?req_id="+requests[i].getRequestID()+"'>V</a></td>");
				    out.println("<td><a href='DenyRequestServlet?req_id="+requests[i].getRequestID()+"'>X</a></td>");
				    out.println("<td></td>");

			    } else {
				    out.println("<td></td>");
				    out.println("<td></td>");
				    out.println("<td><a href='DoneRequestServlet?req_id="+requests[i].getRequestID()+"'>X</a></td>");

			    } 
			    out.println("</tr>");
		  }
		  %>
 	 </table>
</div>
