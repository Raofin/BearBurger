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
        <h1 class="welcome-title">Eat and Order<br>Do It Easy</h1>
        <p>Choose your favourite foods and get it to taste the amazing taste, enjoy it with your family or friends.</p>
        <button class="button" onclick="location.href='/login'">Get Started</button>
    </div>
</div>

<c:import url="/templates/Footer.jsp"/>