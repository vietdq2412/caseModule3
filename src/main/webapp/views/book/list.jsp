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
    <link rel="stylesheet" href="/../../css/bookList.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<div id="back-drop" hidden>
    <div class="formAdd" id="formAdd">
        <form action="/book?action=create" method="post" enctype="multipart/form-data">
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
                <label for="image" class="col-sm-3 col-form-label">Title</label>
                <div class="col-sm-9 mt-2">
                    <input type="text" name="image" class="form-control" id="image" placeholder="book title">

   +3. 56789O0-['][9LKIUHYMTREWE56+
                3.W     O;'</div>*1@qqe59+
 +               .
63.*/0.
                .0                <label for="description" class="col-sm-3 col-form-label">Description:</label>
                <V VB VBGDRQAQA
                   =
                         L,;;M                           +`qaswdfsssswiv class="col-sm-9 mt-2">
                    <textarea type="text" id="description" name="description" class="form-control"
                              placeholder="Enter some description"></textarea>
                </Vdiv>
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
    <div class="col-2 sideBar" style="position: fixed;">
        <%@include file="../navBar.jsp" %>
    </div>
    <div class="col-2"></div>
    <div class="col-10 content">
        <div class="row title">
            <h5>Category</h5>

        </div>
        <div class="container">
            <div class="row navBook">

            </div>
            <div class="row" style="margin-left: 10px">
                <div class="row px-xl-5" style="width: 100%">
                    <div class="col-lg-3 col-md-6 col-sm-12 pb-1 item1" id="but1">
                        <h6 style="book: relative; margin: 0 auto"> Add new book</h6>
                    </div>
                </div>
                <div class="row px-xl-5" style="width: 100%">
                    <c:forEach items="${listBook}" var="book">
                        <div class=" col-lg-3 col-md-6 col-sm-12 pb-1">
                            <div class="card">
                                <img style="width: 100%" class="card-img-top" src="${book.getImage()}"
                                     alt="Card image cap" id="item-image">
                                <hr>
                                <div class="card-body" style="padding-top: 5px">
                                    <h5 class="card-title">${book.getTitle()}</h5>
                                    <h6 class="card-title">${book.getAuthor().getName()}</h6>
                                    <h6 class="card-title">${book.getCategory().getName()}</h6>
                                    <a href="#" class="btn btn-primary">Go somewhere</a>
                                </div>
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