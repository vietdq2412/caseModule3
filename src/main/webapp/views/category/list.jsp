<%--
  Created by Intell
</html>
iJ IDEA.
User: vietd
Date: 23/06/2022
Time: 1:47 CH
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>list category</title>
    <%@include file="../linkBootstrap.jsp" %>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <style>
        .sideBar {
            padding: 0;
        }
    </style>
</head>
<body>
<div id="back-drop" hidden>
    <div class="formAddAuthor" id="formAddAuthor">
        <form action="/category?action=create" method="post">
            <div class="form-group row">
                <label for="name" class="col-sm-2 col-form-label">Name</label>
                <div class="col-sm-10">
                    <input type="text" name="name" class="form-control" id="name" placeholder="category name">
                </div>
            </div>
            <button>Add</button>
        </form>
    </div>
</div>

<div class="row" style="height: 100%">
    <div class="col-2 sideBar">
        <%@include file="../navBar.jsp" %>
    </div>

    <div class="col-10 content">
        <div class="title">
            <h5>Category</h5>
        </div>
        <div class="container">
            <div class="row">
                <div class="row px-xl-5">
                    <div id="but1">
                        <h6><button>Add new category</button></h6>
                    </div>
                </div>
                <div class="row px-xl-5" style="width: 100%">
                    <c:forEach items="${categoryList}" var="category">
                        <div class="col-lg-3 col-md-6 col-sm-12 pb-1">
                            <div class="item">
                            Name:<i><c:out value="${category.getName()}"></c:out></i><br>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    $(document).ready(function () {
        $("#but1").click(function () {
            document.getElementById("back-drop").hidden = false;

        });
        $("#but2").click(function () {
            document.getElementById("back-drop").hidden = true;
        });
    });
</script>
</body>