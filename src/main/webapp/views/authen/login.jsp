<%--
  Created by IntelliJ IDEA.
  User: vietd
  Date: 18/05/2022
  Time: 5:29 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <%@include file="../linkBootstrap.jsp" %>

</head>
<style>
    .form-login {
        width: 50%;
        height: max-content;
        margin: 0 auto;
        margin-top: 100px;
        padding-top: 20px;
        border-radius: 25px 25px 25px 25px;
        -moz-border-radius: 25px 25px 25px 25px;
        -webkit-border-radius: 25px 25px 25px 25px;
        border: 2px solid #440d0d;
        background-color: beige;
        text-align: center;
    }

    .container-fluid {
        text-align: center;
    }

    .login-head {
    }

    body {
        background-color: aliceblue;
    }

    input {
        border-radius: 3px 3px 3px 3px;
        -moz-border-radius: 3px 3px 3px 3px;
        -webkit-border-radius: 3px 3px 3px 3px;
        border: 1px solid rgba(79, 78, 78, 0.88);
    }
</style>
<body>
<div class="container-fluid">
    <div class="col login-head"><h1>Login</h1></div>
    <div class="col form-login">
        <h6 style="color: #d22323">${error}</h6>
        <h6>${message}</h6>
        <form action="authen?action=login" method="post">
            <fieldset>
                <label for="email">Username:</label>
                <input type="text" id="email" name="email">
                <br><br>
                <label for="password">Password:</label>
                <input type="password" id="password" name="password">
                <br><br>
                <button class="btn btn-secondary">Login</button>
            </fieldset>
        </form>
        <a href="authen?action=register">Register</a>
    </div>
</div>
</body>
</html>
