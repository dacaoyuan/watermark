<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/7/29
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<title>处理结果</title>
</head>
<body>
	<table width="99%" align="center">
		<s:iterator value="picInfo">
			<tr>
				<td width="50%"><img
					src='${pageContext.request.contextPath}<s:property value="imageURL"/>'
					width="550" /></td>
				<td width="50%"><img
					src='${pageContext.request.contextPath}<s:property value="logoImageURL"/>'
					width="550" /></td>
			</tr>
		</s:iterator>

	</table>
</body>
</html>
