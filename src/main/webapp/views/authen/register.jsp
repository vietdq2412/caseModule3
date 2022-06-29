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
    <title>Register</title>
    <%@include file="../linkBootstrap.jsp" %>

</head>
<style>
    .form-login {
        width: 50%;
        height: max-content;
        margin-top: 50px;
        margin-left: 100px;
        padding: 20px 20px 5px;
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
    fieldset{
        position: relative;
    }
    fieldset label{
        float: left;
    }
    fieldset input{
        float: right;
        width: 75%;
    }
</style>
<body>
<h1>${message}</h1>
<div class="container-fluid">
    <div class="col form-login">
        <h4 style="color: #d22323">${error}</h4>
        <form action="authen?action=register" method="post">
            <fieldset>
                <label for="email">Email:</label>
                <input type="text" id="email" name="email" pattern="^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$">
                <br><br>
                <label for="password">Password:</label>
                <input type="password" id="password" name="password">
                <br><br>
                <button class="btn btn-secondary" >Register</button>
            </fieldset>
        </form>
    </div>
</div>

</script>
</body>
</html>
