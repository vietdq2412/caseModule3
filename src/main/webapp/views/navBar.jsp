<style>

    /*////////////////////////////////*/
    body {
        background-color: #d3cbbc;
    }

    html, body {
        height: 100%;
    }

    .sideNav {
        width: 100%;
        height: 100%;
    }

    .title {
        text-align: center;
        height: 20%;
        background-color: rgba(199, 182, 182, 0.49);
        margin-bottom: 5px;
    }

    .account {
        width: 100%;
        height: 20%;
        background-color: #56514c;
        margin: 0;
        padding: 0;
    }

    .account h3 {
        text-align: center;
    }

/*/////////Menu*/
    body {
        font-family: sans-serif;
        font-size: 15px;
    }
    #menu{
        width: 100%;
        margin: 0;
        padding: 0;
    }
    #menu ul {
        background: #8d7b55;
        width: 100%;
        padding: 0;
        list-style-type: none;
        text-align: left;
    }
    #menu li {
        width: auto;
        height: 40px;
        line-height: 40px;
        border-bottom: 1px solid #e8e8e8;
        padding: 0 1em;
    }
    #menu a {
        text-decoration: none;
        color: #333;
        font-weight: bold;
        display: block;
    }
    #menu li:hover {
        background: #CDE2CD;
    }

    #menu ul li {
        position: relative;
    }
</style>
<%@ taglib prefix='navBar' uri='http://java.sun.com/jsp/jstl/core' %>
<div class="sideNav">
    <div class="row account">
        <h3><a href="/AppUser?action=detail">Account</a></h3>
    </div>
    <div class="row" id="menu">
        <ul>
            <a href="/"><li>Home</li></a>
            <a href="/book?action=list"><li>Book</li></a>
            <a href="/author?action=list"><li>Author</li></a>
            <a href="/position?action=list"><li>Position</li></a>
            <a href="/category?action=list"><li>Category</li></a>
            <navBar:if test="${user == null}">
                <a href="/authen?action=login"><li>Login</li></a>
            </navBar:if>
            <navBar:if test="${user != null}">
                <a href="/authen?action=logout"><li>Logout</li></a>
            </navBar:if>
        </ul>
    </div>
</div>



