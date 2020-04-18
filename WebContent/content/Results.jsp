
<%@page import="model.Items"%>
<%@page import="java.util.*"%>
<jsp:include page="Search.jsp" />
<div class='w3-row'>
	<%
	request.setAttribute("items",request.getAttribute("results"));

	out.print("you was looking for " + request.getAttribute("search"));
%>		
<jsp:include page="ShowItems.jsp">
	<jsp:param value="${results}" name="items"/>
</jsp:include>
</div>
	