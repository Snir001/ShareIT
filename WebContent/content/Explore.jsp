<%@page import="java.util.List"%>

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



