
<%@page import="model.Items"%>
<%@page import="java.util.*"%>
<jsp:include page="Search.jsp" />
<% 
out.print("you was looking for " + request.getAttribute("search"));
out.print("<div class='w3-row'>");

		
List<Items> results=(List<Items>)request.getAttribute("results");
for(int i=0;i<results.size();i++){
	out.print("<div class='w3-col s12 m4 l3 w3-center w3-card-4' style=''>");
	out.print("<a href=ItemDetailsServlet?id="+results.get(i).getItemID()+"><img src='photos/ladder.jpg' class='w3-round w3-padding-16' height='150' width='150'>");
	out.print("<h5>item " +results.get(i).getName()+ "</h5>");
	out.print("</div>");
}
out.print("</div>");

%>		

	