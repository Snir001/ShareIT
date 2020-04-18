<%@page import="java.util.List"%>

<a href="ProfileServlet"> users only!</a>
<a href="ExploreServlet"> Explore Page </a>
<!-- Items -->
<h3 class="w3-margin">New Items!</h3>
	<%
    model.Model mod = (model.Model)getServletContext().getAttribute("model");
	List<model.Items> items=mod.getAllItemsList();
	request.setAttribute("items", items);
	%>
	<jsp:include page="ShowItems.jsp">
	<jsp:param value="${items}" name="items"/>
	</jsp:include>



