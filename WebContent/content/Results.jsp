
<%@page import="model.Items"%>
<jsp:include page="Search.jsp" />
<% 
out.print("you was looking for " + request.getAttribute("search"));
out.print("<div class='w3-row'>");

//TODO: show all resolts of the search
//model.Items[] results=(model.Items[])request.getAttribute("results");
for(int i=0;i<18;i++){
	out.print("<div class='w3-col s12 m4 l3 w3-center w3-card-4' style=''>");
	out.print("<a href=ItemDetailsServlet?id="+i+"><img src='photos/ladder.jpg' class='w3-round w3-padding-16' height='150' width='150'>");
	out.print("<h5>item " + i + "</h5>");
	out.print("</div>");
}
out.print("</div>");

%>		

	