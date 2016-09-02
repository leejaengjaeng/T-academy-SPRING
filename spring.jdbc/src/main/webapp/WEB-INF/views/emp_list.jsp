<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>emp_list.jsp</h2>
	<hr>
	
	<table border="1">
		<tr>
			<th>empno</th>
			<th>ename</th>
			<th>sal</th>
		</tr>
		<c:forEach items="${emps }" var="e">
		<tr>
			<td>${e.empno }</td>
			<td>${e.ename }</td>
			<td>${e.sal }</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>