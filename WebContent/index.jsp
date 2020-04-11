<%@ page language="java" contentType="text/html; charset=windows-1255"
	pageEncoding="windows-1255"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="jsp/head.jsp">
		<jsp:param name='title' value="ShareIT" />
	</jsp:include>
</head>
<body>

	<jsp:include page="jsp/bodyHeader.jsp">
		<jsp:param name='title' value="Welcome!" />
	</jsp:include>
	
	<div class="w3-main" style="margin-left: 250px">
	
		<jsp:include page="content/Explore.jsp" />
	
	</div>

</body>
</html>