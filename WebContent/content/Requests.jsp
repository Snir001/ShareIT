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
	      String changeReqServlet="ChangeRequestResponeServlet";
		  Requests[] requests=(Requests[])request.getAttribute("requests");
		  String status;
		  for(int i=0;i<requests.length;i++) {
			  if(requests[i].getResponse().equals("0")) {status="Waiting";}
			  if(requests[i].getResponse().equals("1")) {status="Approved";}
			  if(requests[i].getResponse().equals("2")) {status="Denyed";}
			  if(requests[i].getResponse().equals("3")) {status="Done";}
			  if(requests[i].getResponse().equals("4")) {status="Canceled";}

			  else {status="Unknown";}

			    out.println("<tr>");
			    out.println("<td><a href='ItemDetailsServlet?id="+requests[i].getItemID()+"'>"+requests[i].getItemID()+"</a></td>");
			    out.println("<td>"+requests[i].getBorrowerID()+"</td>");
			    out.println("<td>"+requests[i].getPeriod()+"</td>");
			    out.println("<td>"+requests[i].getDate()+"</td>");
			    out.println("<td>"+status+"</td>");
			    if(requests[i].getResponse().equals("0")){
				    out.println("<td><a href='"+changeReqServlet+"?req_id="+requests[i].getRequestID()+"&new_resp=1'>V</a></td>");
				    out.println("<td><a href='"+changeReqServlet+"?req_id="+requests[i].getRequestID()+"&new_resp=2'>X</a></td>");
				    out.println("<td>-</td>");
			    } else {
				    if(requests[i].getResponse().equals("1")){
					    out.println("<td>-</td>");
					    out.println("<td>-</td>");
					    out.println("<td><a href='"+changeReqServlet+"?req_id="+requests[i].getRequestID()+"&new_resp=3'>D</a></td>");
				    } else {
				    out.println("<td>-</td>");
				    out.println("<td>-</td>");
				    out.println("<td>-</td>");
				    }
			    } 
			    out.println("</tr>");
		  }
		  %>
 	 </table>
</div>
