
<jsp:include page="Search.jsp" />
<% 
out.print("you was looking for " + request.getAttribute("search"));
//TODO: show all resolts of the search
%>		

	