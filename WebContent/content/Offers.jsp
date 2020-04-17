this is list of ${name} Offers
<%@page import="model.Requests"%>
<div class="w3-container">
  <h2>Striped Table</h2>
  <p>The w3-striped class adds zebra-stripes to a table:</p>

  <table class="w3-table w3-striped">
    <tr>
      <th>Item ID</th>
      <th>Owner</th>
      <th>Period</th>
      <th>Offer date</th>
      <th>Status</th>
      <th>Cancel</th>
    </tr>
    <tr>
      <td>Item ID</td>
      <td>Owner</td>
      <td>Period</td>
      <td>Offer date</td>
      <td>Status</td>
      <td>Cancel</td>

    </tr>
	      <%
	      model.Model mod = (model.Model)getServletContext().getAttribute("model");
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
			    out.println("<td>"+mod.getUserById(requests[i].getOwnerID()).getUserName()+"</td>");
			    out.println("<td>"+requests[i].getPeriod()+"</td>");
			    out.println("<td>"+requests[i].getDate()+"</td>");
			    out.println("<td>"+status+"</td>");
			    if(requests[i].getResponse().equals("0")){
				    out.println("<td><a href='"+changeReqServlet+"?req_id="+requests[i].getRequestID()+"&new_resp=4'>C</a></td>");

			    } else {
				    out.println("<td></td>");

			    } 
			    out.println("</tr>");
		  }
		  %>
 	 </table>
</div>

