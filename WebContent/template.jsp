<%@ page language="java" contentType="text/html; charset=windows-1255"
	pageEncoding="windows-1255"%>
<!DOCTYPE html>
<html>
<head>
<%// String title=(String)request.getAttribute("title"); %>
<jsp:include page="jsp/head.jsp">
	<jsp:param name='title' value="${title}" />
</jsp:include>
	<%// out.print(request.getAttribute("title")); %>
</head>
<body>

	<jsp:include page="jsp/bodyHeader.jsp">
		<jsp:param name='title' value="${title}" />
	</jsp:include>
	
	
	<div class="w3-main" style="margin-left: 250px; margin-right: 50px">
	<jsp:include page="${page}" />
	
	</div>

</body>
</html>