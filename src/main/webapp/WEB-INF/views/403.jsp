<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <link href="<c:url value="/assets/css/style.css"/>" rel="stylesheet" type="text/css">
    <title>Bear Burger</title>
</head>

<body>

<header>
    <a class="logo" href=""><img src="<c:url value="/assets/img/nav-logo.svg"/>" alt="logo"></a>
    <nav>
        <ul class="nav-links">
            <li><a href="">Project Details</a></li>
        </ul>
    </nav>
</header>

<div class="welcome" id="welcome">
    <img alt="logo" class="welcome-logo" src="<c:url value="/assets/img/logo.svg"/>">
    <div class="welcome-message">
        <h1 class="welcome-title">Access Denied!</h1>
        <h3 class="welcome-title">You don't have the permission to access this page.</h3>
    </div>
</div>

</body>

<footer class="footer">
    <p>Copyright © 2022 by <a href="https://raofin.net">Raofin</a>. All Rights Reserved.</p>
</footer>

</html>
