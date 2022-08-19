<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <link href="<c:url value="/assets/css/style.css"/>" rel="stylesheet" type="text/css">
    <script src="<c:url value="/assets/js/jquery-3.6.0.min.js"/>"></script>
    <script src="<c:url value="/assets/js/jquery.validate.js"/>"></script>
    <title>Bear Burger</title>
</head>
<body>

<header>
    <a class="logo" href="<c:url value="/WEB-INF/views/index.jsp"/>"><img src="<c:url value="/assets/img/nav-logo.svg"/>" alt="logo"></a>
    <nav>
        <ul class="nav-links">
            <li><a href="">Home</a></li>
            <li><a href="">Search Foods</a></li>

            <%--<?php
                if (!isset($_SESSION['username'])) echo "--%>
            <li><a href="">Log In</a></li>
            <li><a href="">Register</a></li>";
<%--            else echo "--%>
            <li><a href="">View Profile</a></li>
            <li><a href="<c:url value="/logout"/>">Log Out</a></li>

            <li><form:form action="logout" method="POST">
                <input type="submit" value="logout">
            </form:form></li>
            <li class='username'><a href="">{<%--$_SESSION['username']--%>}</a></li>";
<%--            ?>
            <li><a class="project-details" href="">Project Details</a></li>--%>
        </ul>
    </nav>
</header>
