<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1255">
<title>See Image</title>
</head>
<body>

	<h1><% out.print(request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath());%></h1>
	<img src="<% out.print(request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath());%>/images/file11" />

</body>
</html>