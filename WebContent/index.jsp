<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/7/29
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<html>
<head>
<title>上传图片</title>
</head>
<body>
	<h4>上传图片</h4>
	<hr />
	<form name="form1"
		action="${pageContext.request.contextPath}/watermark.action"
		method="post" enctype="multipart/form-data">

		<input type="file" name="image" /><br> 
		<br>
		<input type="file"name="image" /><br> 
		<br>
		<input type="file" name="image" /><br>
		<br>
		<input type="file" name="image" /><br> 
		<br>
		<input type="file"name="image" /><br> 
		<br>
		<input type="submit" value="上传图片" />

	</form>
	<hr />
</body>
</html>
