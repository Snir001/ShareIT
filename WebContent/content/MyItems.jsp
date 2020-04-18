 this is list of ${name} items
<%@page import="java.util.List"%>
<%@page import="model.Items"%>
<jsp:include page="ShowItems.jsp">
	<jsp:param value="${items}" name="items"/>
</jsp:include>
