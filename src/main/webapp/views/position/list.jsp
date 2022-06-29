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
    <title>list position</title>
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
    </style>
</head>
<body>
<div id="back-drop" hidden>
    <div class="formAdd" id="formAdd">
        <form action="/position?action=create" method="post">
            <div class="form-group row">
                <label for="name" class="col-sm-2 col-form-label">Name</label>
                <div class="col-sm-10 mt-2">
                    <input type="text" name="name" class="form-control" id="name" placeholder="position name">
                </div>
                <label for="currentUnit" class="col-sm-2  col-form-label">On-shelf:</label>
                <div class="col-sm-10 mt-2">
                    <input type="number" id="currentUnit" name="currentUnit" class="form-control" value="0">
                </div>
                <label for="maxSize" class="col-sm-2 col-form-label">Max size:</label>
                <div class="col-sm-10 mt-2">
                    <input type="number" id="maxSize" name="maxSize" class="form-control" value="0">
                </div>
                <label for="description" class="col-sm-2 col-form-label">Description:</label>
                <div class="col-sm-10 mt-2">
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
                        <h6 style="position: relative; margin: 0 auto"> Add new position</h6>
                    </div>
                </div>
                <div class="row px-xl-5" style="width: 100%">
                    <c:forEach items="${positionList}" var="position">
                        <div class="col-lg-3 col-md-6 col-sm-12 pb-1">
                            <div class="item">
                                Name:<c:out value="${position.getName()}"></c:out><br>
                                <i>Limit: <c:out value="${position.getMaxSize()}"></c:out></i><br>
                                <i>On-shelf: <c:out value="${position.getCurrentUnit()}"></c:out></i><br>
                                <hr style="margin-top: 0">
                                <p><c:out value="${position.getDescription()}"></c:out></p><br>
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