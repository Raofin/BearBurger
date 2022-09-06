<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <link rel="icon" type="image/png" href="<c:url value="/resources/static/img/logo.svg"/>"/>
    <link rel="preload" href="<c:url value="/resources/static/img/background.jpg"/>" as="image">
    <link href="<c:url value="/resources/static/css/style.css"/>" rel="stylesheet" type="text/css">
    <title>Bear Burger</title>
</head>

<body>

<header>
    <a class="logo" href=""><img src="<c:url value="/resources/static/img/nav-logo.svg"/>" alt="logo"></a>
    <nav>
        <ul class="nav-links">
            <li><a href="">Project Details</a></li>
        </ul>
    </nav>
</header>

<div class="welcome" id="welcome">
    <img alt="logo" class="welcome-logo" src="<c:url value="/resources/static/img/logo.svg"/>">
    <div class="welcome-message">
        <span class="error-number">403</span>
        <span class="error-page-title">Forbidden</span>
        <span>You don't have the permission to access this page.</span>
    </div>
</div>

</body>

<footer class="footer">
    <p>Copyright &copy 2022 by <a href="https://raofin.net">Raofin</a>. All Rights Reserved.</p>
</footer>

</html>
