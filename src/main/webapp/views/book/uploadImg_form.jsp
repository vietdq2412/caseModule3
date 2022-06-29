<%--
  Created by IntelliJ IDEA.
  User: vietd
  Date: 18/05/2022
  Time: 3:18 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="../navBar.jsp" %>

<h1>Upload img</h1>
<form action="/app?action=uploadImg" enctype="multipart/form-data" method="post">
    <input type="file" name="file">
    <button>Submit</button>
</form>
</body>
</html>
