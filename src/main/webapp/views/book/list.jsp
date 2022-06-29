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
    <title>list book</title>
    <%@include file="../linkBootstrap.jsp" %>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

    <style>
        .item i, p {
            font-size: small;
        }

        .item {
            height: 150px;
        }

        .form-btn {
            text-align: center;
        }

        .cancel-btn {
            background-color: #d22323;
            width: fit-content;
            border-radius: 8px 8px 8px 8px;
            -webkit-border-radius: 8px 8px 8px 8px;
            -moz-border-radius: 8px 8px 8px 8px;
        }

        .cancel-btn:hover {
            background-color: rgba(215, 121, 121, 0.47);
            cursor: pointer;
        }

        .add-btn {
            width: fit-content;
            border-radius: 8px 8px 8px 8px;
            -webkit-border-radius: 8px 8px 8px 8px;
            -moz-border-radius: 8px 8px 8px 8px;
        }

        .formAdd {
            height: max-content;
            padding: 5px;
        }

        .sideBar, .content {
            padding: 0;
        }

        .custom-select {
            width: 100%;
            margin: 0;
        }
    </style>
</head>
<body>
<div id="back-drop" hidden>
    <div class="formAdd" id="formAdd">
        <form action="/book?action=create" method="post">
            <div class="form-group row">
                <label for="title" class="col-sm-3 col-form-label">Title</label>
                <div class="col-sm-9 mt-2">
                    <input type="text" name="title" class="form-control" id="title" placeholder="book title">
                </div>
                <label for="author" class="col-sm-3 col-form-label">Author:</label>
                <div class="col-sm-9 mt-2">
                    <select class="form-control custom-select" id="author" name="author" onfocus='this.size=3;'
                            onblur='this.size=1;' onchange='this.size=1; this.blur();'>
                        <option value="${null}" selected>author</option>
                        <c:forEach items="${listAuthor}" var="author">
                            <option value="${author.getId()}">${author.getName()}</option>
                        </c:forEach>
                    </select>
                </div>
                <label for="category" class="col-sm-3 col-form-label">Category:</label>
                <div class="col-sm-9 mt-2">
                    <select class="form-control custom-select" id="category" name="category" onfocus='this.size=3;'
                            onblur='this.size=1;' onchange='this.size=1; this.blur();'>
                        <option value="${null}" selected>category</option>

                        <c:forEach items="${listCategory}" var="cas">
                            <option value="${cas.getId()}">${cas.getName()}</option>
                        </c:forEach>
                    </select>
                </div>
                <label for="position" class="col-sm-3 col-form-label">Position:</label>
                <div class="col-sm-9 mt-2">
                    <select class="form-control custom-select" id="position" name="position" onfocus='this.size=3;'
                            onblur='this.size=1;' onchange='this.size=1; this.blur();'>
                        <option value="${null}" selected>position</option>
                        <c:forEach items="${listPosition}" var="pos">
                            <option value="${pos.getId()}">${pos.getName()}</option>
                        </c:forEach>
                    </select>
                </div>
                <label for="description" class="col-sm-3 col-form-label">Description:</label>
                <div class="col-sm-9 mt-2">
                    <textarea type="text" id="description" name="description" class="form-control"
                              placeholder="Enter some description"></textarea>
                </div>
            </div>
            <div class="form-group row mt-2">
                <div class="col-6 form-btn">
                    <button class="add-btn">Add</button>
                </div>
                <div class="col-6 form-btn cancel-btn">
                    <a id="but2">Cancel</a>
                </div>
            </div>
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
                <div class="row px-xl-5" style="width: 100%">
                    <div class="col-lg-3 col-md-6 col-sm-12 pb-1 item1" id="but1">
                        <h6 style="book: relative; margin: 0 auto"> Add new book</h6>
                    </div>
                </div>
                <div class="row px-xl-5" style="width: 100%">
                    <c:forEach items="${bookList}" var="book">
                        <div class="col-lg-3 col-md-6 col-sm-12 pb-1">
                            <div class="item">
                                Name:<c:out value="${book.getTitle()}"></c:out><br>
                                <i>Limit: <c:out value="${book.getAuthor()}"></c:out></i><br>
                                <i>On-shelf: <c:out value="${book.getImage()}"></c:out></i><br>
                                <hr style="margin-top: 0">
                                <p><c:out value="${book.getDescription()}"></c:out></p><br>
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