<%--
  Created by IntelliJ IDEA.
  User: vietd
  Date: 23/06/2022
  Time: 10:12 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create author</title>
    <%@include file="../linkBootstrap.jsp" %>
</head>
<body>
<%@include file="../navBar.jsp" %>
<div class="container"></div>
<form action="/author?action=create" method="post">
    <div class="form-group row">
        <label for="name" class="col-sm-2 col-form-label">Name</label>
        <div class="col-sm-10">
            <input type="text" name="name" class="form-control" id="name" value="email@example.com">
        </div>
    </div>
    <div class="form-group row">
        <label for="inputDate" class="col-sm-2 col-form-label">DOB</label>
        <div class="col-sm-10">
            <input type="date" name="date" class="form-control" id="inputDate" placeholder="Password">
        </div>
    </div>
    <button>Add</button>
</form>
</body>
</html>
