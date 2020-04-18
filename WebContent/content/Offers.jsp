this is list of ${name} Offers
<%@page import="model.Requests"%>
<%@page import="java.util.*"%>

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

	      <%
	      model.Model mod = (model.Model)getServletContext().getAttribute("model");
	      String changeReqServlet="ChangeRequestResponeServlet";
	      List<model.Requests> requests=(List<model.Requests>)request.getAttribute("requests");
		  String status;
		  for(int i=0;i<requests.size();i++) {
			  if(requests.get(i).getResponse().equals("0")) {status="Waiting";}
			  if(requests.get(i).getResponse().equals("1")) {status="Approved";}
			  if(requests.get(i).getResponse().equals("2")) {status="Denyed";}
			  if(requests.get(i).getResponse().equals("3")) {status="Done";}
			  if(requests.get(i).getResponse().equals("4")) {status="Canceled";}

			  else {status="Unknown";}
			    out.println("<tr>");
			    out.println("<td><a href='ItemDetailsServlet?id="+requests.get(i).getItemID()+"'>"+requests.get(i).getItemID()+"</a></td>");
			    out.println("<td>"+mod.getUserByID(requests.get(i).getOwnerID()).getUserName()+"</td>");
			    out.println("<td>"+requests.get(i).getPeriod()+"</td>");
			    out.println("<td>"+requests.get(i).getDate()+"</td>");
			    out.println("<td>"+status+"</td>");
			    if(requests.get(i).getResponse().equals("0")){
				    out.println("<td><a href='"+changeReqServlet+"?req_id="+requests.get(i).getRequestID()+"&new_resp=4'>C</a></td>");

			    } else {
				    out.println("<td></td>");

			    } 
			    out.println("</tr>");
		  }
		  %>
 	 </table>
</div>

