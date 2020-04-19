this is list of ${name} Offers
<%@page import="model.Users"%>
<%@page import="model.Requests"%>
<%@page import="java.util.*"%>

<div class="w3-container">
	<h2>Users:</h2>

	<table class="w3-table w3-striped">
		<tr>
			<th>User ID</th>
			<th>User Name</th>
			<th>Last Name</th>
			<th>First Name</th>
			<th>Mail</th>
			<th>City</th>
			<th>Address</th>
			<th>Phone</th>
			<th>Gender</th>
			<th>privleges</th>
			<th>Make Admin</th>
			
			<th>Delete</th>



		</tr>

		<%
	      List<model.Users> users=(List<model.Users>)request.getAttribute("users");
		  String status;
		  Users u;
		  for(int i=0;i<users.size();i++) {
			  u=users.get(i);
			  /*
  			<th>User ID</th>
			<th>User Name</th>
			<th>Last Name</th>
			<th>First Name</th>
			<th>Mail</th>
			<th>City</th>
			<th>Address</th>
			<th>Phone</th>
			<th>Gender</th>
			<th>privleges</th>
			http://localhost:8080/ShareIT/ProfilePageServlet?user_name=Idan_Sh
			  */
			    out.println("<tr>");
			    out.println("<td>"+u.getUserID()+"</td>");
			    out.println("<td><a href='ProfilePageServlet?user_name="+u.getUserName()+"'>"+u.getUserName()+"</a></td>");
			    out.println("<td>"+u.getLastName()+"</td>");
			    out.println("<td>"+u.getFirstName()+"</td>");
			    out.println("<td>"+u.getMail()+"</td>");
			    out.println("<td>"+u.getCity()+"</td>");
			    out.println("<td>"+u.getAddress()+"</td>");
			    out.println("<td>"+u.getPhone()+"</td>");
			    out.println("<td>"+u.getGender()+"</td>");
			    out.println("<td>"+u.getPrivileges()+"</td>");
			    out.println("<td><a href='MakeAdminServlet?user_id="+u.getUserID()+"'>A</a></td>");
			    out.println("<td><a href='RemoveUserServlet?user_id="+u.getUserID()+"'>X</a></td>");

			    out.println("</tr>");
		  }
		  %>
	</table>
</div>

