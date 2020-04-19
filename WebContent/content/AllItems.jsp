this is list of ${name} Offers
<%@page import="model.Users"%>
<%@page import="model.Requests"%>
<%@page import="java.util.*"%>

<div class="w3-container">
	<h2>Users:</h2>

	<table class="w3-table w3-striped">
		<tr>
			<th>Item ID</th>
			<th>Item Name</th>
			<th>Item Owner</th>
			<th>Category</th>
			<th>Value</th>
			<th>Condition</th>
			<th>Picture</th>
			<th>Delete</th>



		</tr>

		<%
	      model.Model mod = (model.Model)getServletContext().getAttribute("model");
	      List<model.Items> items=(List<model.Items>)request.getAttribute("items");
		  String status;
		  model.Items item;
		  for(int i=0;i<items.size();i++) {
			  item=items.get(i);
			  /*
			<th>Item ID</th>
			<th>Item Name</th>
			<th>Item Owner</th>
			<th>Category</th>
			<th>Value</th>
			<th>Condition</th>
			<th>Picture</th>
			<th>Delete</th>
			http://localhost:8080/ShareIT/ProfilePageServlet?user_name=Idan_Sh
			  */
			    out.println("<tr>");
			    out.println("<td>"+item.getItemID()+"</td>");
			    out.println("<td>"+item.getName()+"</td>");
			    out.println("<td><a href='ProfilePageServlet?user_name="+mod.getUserByID(item.getOwnerID()).getUserName()+"'>"+mod.getUserByID(item.getOwnerID()).getUserName()+"</a></td>");
			    out.println("<td>"+item.getCategory()+"</td>");
			    out.println("<td>"+item.getItemValue()+"</td>");
			    out.println("<td>"+item.getCondition()+"</td>");
			    out.println("<td>"+item.getPicture()+"</td>");
			    out.println("<td><a href='RemoveItemServlet?item_id="+item.getItemID()+"'>X</a></td>");

			    out.println("</tr>");
		  }
		  %>
	</table>
</div>

