<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<%@include file="navBar.jsp" %>

<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="app">Hello Servlet</a><br>
<a href="app?action=add">add</a><br>
<a href="app?action=list">show</a><br>
<a href="app?action=uploadImg">upload</a><br>
<a href="authen?action=register">register</a><br>
<a href="authen?action=login">Login</a><br>

<hr>
<c:if test="${user != null}">
    <h1>email: ${user}</h1>
</c:if>
<h1 style="color: #d22323">${error}</h1>
<h1>${message}</h1>
</body>
</html>