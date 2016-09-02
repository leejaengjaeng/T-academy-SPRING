<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>
	<hr>
	
	<a href="/hello">hello.jsp 잘 못 된 링크 > 접근결과: http://localhost:8080/hello</a><br>
	<a href="lazy">lazy.jsp</a><br>
	<hr>
	
	<a href="hello">hello.jsp</a><br>
	<a href="hello/one">hello/one.jsp</a><br>
	<hr>
	
	<a href="diablo/asia/gildong">diablo/asia/asia.jsp</a><br>
	<hr>
	
	<a href="board?action=list">board/list.jsp</a><br>
	<hr>
	
	<a href="model/ret_string">model/ret_string.jsp</a><br>
	<a href="model/ret_modelandview">model/ret_modelandview.jsp</a><br>
	<hr>
	
	<a href="login">login/login_form.jsp</a><br>
	<hr>
	
	<a href="param/test1">param/test1.jsp</a><br>
	<a href="param/test2">param/test2.jsp</a><br>
	<a href="param/test3">param/test3.jsp</a><br>
	<a href="param/test6">param/test6.jsp</a><br>
	<a href="param/test8">param/test8.jsp</a><br>
	<a href="param/test10">json</a><br>
	<hr>
	
	<a href="enroll?action=one">enroll/enroll_one.jsp</a><br>
	<hr>
	
	<a href="none">없는페이지, web.xml 참조</a><br>
	<a href="divide">0으로 나누기, error404(Exception ex) 메소드 애노테이션 참조</a><br>
	<a href="throw">직접 Exception 발생 시키기, web.xml 참조</a><br>
	<a href="custom_exception">직접 만든 CustomGenericException 발생 시키기</a><br>
	
</body>
</html>
