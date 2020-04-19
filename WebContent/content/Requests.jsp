<%@page import="model.Requests"%>
<%@page import="java.util.*"%>
<div class="w3-container">
  <p>People want this item from you</p>

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

	      <%
	      model.Model mod = (model.Model)getServletContext().getAttribute("model");

	      String changeReqServlet="ChangeRequestResponeServlet";
	      List<Requests> requests=(List<Requests>)request.getAttribute("requests");
		  String status;
		  Requests req;
		  for(int i=0;i<requests.size();i++) {
			  req=requests.get(i);
			  if(req.getResponse().equals("0")) {status="Waiting";}
			  else if(req.getResponse().equals("1")) {status="Approved";}
			  else if(req.getResponse().equals("2")) {status="Denyed";}
			  else if(req.getResponse().equals("3")) {status="Done";}
			  else if(req.getResponse().equals("4")) {status="Canceled";}
			  else {status="Unknown";}
			  


			    out.println("<tr>");
			    out.println("<td><a href='ItemDetailsServlet?id="+req.getItemID()+"'>"+req.getItemID()+"</a></td>");
			    out.println("<td>"+mod.getUserByID(req.getBorrowerID()).getUserName()+"</td>");
			    out.println("<td>"+req.getPeriod()+"</td>");
			    out.println("<td>"+req.getDate()+"</td>");
			    out.println("<td>"+status+"</td>");
			    if(req.getResponse().equals("0")){
				    out.println("<td><a href='"+changeReqServlet+"?req_id="+req.getRequestID()+"&new_resp=1'>V</a></td>");
				    out.println("<td><a href='"+changeReqServlet+"?req_id="+req.getRequestID()+"&new_resp=2'>X</a></td>");
				    out.println("<td>-</td>");
			    } else {
				    if(req.getResponse().equals("1")){
					    out.println("<td>-</td>");
					    out.println("<td>-</td>");
					    out.println("<td><a href='"+changeReqServlet+"?req_id="+req.getRequestID()+"&new_resp=3'>D</a></td>");
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
