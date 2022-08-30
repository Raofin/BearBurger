<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <link rel="icon" type="image/png" href="<c:url value="/assets/img/logo.svg"/>"/>
    <link href="<c:url value="/assets/css/style.css"/>" rel="stylesheet" type="text/css">
    <script src="<c:url value="/assets/js/jquery-3.6.0.min.js"/>"></script>
    <script src="<c:url value="/assets/js/jquery.validate.js"/>"></script>
    <title>Bear Burger</title>
</head>
<body>

<header>
    <a class="logo" href="./dashboard"><img src="<c:url value="/assets/img/nav-logo.svg"/>" alt="logo"></a>
    <nav>
        <ul class="nav-links">

            <sec:authorize access="isAnonymous()">
                <li><a href="./home">Home</a></li>
                <li><a href="./search-foods">Search Foods</a></li>
                <li><a href="<c:url value="/login"/>">Log In</a></li>
                <li><a href="./register">Register</a></li>
            </sec:authorize>

            <sec:authorize access="hasAuthority('ADMIN')">
                <li><a href="./home">Home</a></li>
                <li><a href="./dashboard">Admin Panel</a></li>
                <li><a href="./manage-roles">Manage Users</a></li>
                <li><a href="./manage-user">Manage Users</a></li>
                <li><a href="./manage-food">Manage Foods</a></li>
                <li><a href="<c:url value="/logout"/>">Log Out</a></li>
                <li class="username"><a href="./profile">
                    <sec:authentication property="principal.username"/></a></li>
            </sec:authorize>

            <%--            <li><a class="project-details" href="">Project Details</a></li>--%>
        </ul>
    </nav>
</header>
