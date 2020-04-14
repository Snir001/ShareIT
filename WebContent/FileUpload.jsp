<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1255">
<title>upload file</title>
</head>
<body>
<form action="upload" method="post" enctype="multipart/form-data">
    <input type="text" name="description" />
    <input type="file" name="file" value="explore" />
    <input type="submit" value="submit" />
</form>
</body>
</html>