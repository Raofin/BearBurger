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
    <a class="logo" href="../home"><img src="<c:url value="/assets/img/nav-logo.svg"/>" alt="logo"></a>
    <nav>
        <ul class="nav-links">

            <sec:authorize access="hasAuthority('ADMIN')">
                <li><a href="../dashboard">Admin Panel</a></li>
            </sec:authorize>

            <sec:authorize access="hasAnyAuthority('CUSTOMER', 'ADMIN')">
                <li><a href="../home">Home</a></li>
                <li><a href="../search-foods">Search Foods</a></li>
                <li><a href="../profile">View Profile</a></li>
                <li><a href="<c:url value="/logout"/>">Log Out</a></li>
                <li class="username"><a href="../profile">
                    <sec:authentication property="principal.username"/></a></li>
            </sec:authorize>
        </ul>
    </nav>
</header>

<div class="form-container" id="payment-form">
    <form:form action="../api/payment-action" class="" method="POST">
        <div>
            <h1 class="payment-form-title">${food.title}</h1>
            <p class="payment-description">${food.description}</p>
            <p class="payment-price">
                Price: <span id="price" class="white-back-text">${food.price}tk</span>
            </p>
        </div>

        <div class="currency-text">
            <h3 class="">Pay with:
                <a id="taka" class="white-back-text">Taka</a>
                <a id="dollar">Dollar</a>
                <a id="pound">Pound</a>
            </h3>
        </div>

        <div>
            <h2 class="payment-title">Payment</h2>
            <table class="payment-table">
                <tr>
                    <td>Name</td>
                    <td>
                        <input autofocus id="name" name="name" placeholder="Enter your name" type="text"
                               value="<sec:authentication property="principal.username"/>">
                    </td>
                </tr>
                <tr>
                    <td>Card Number</td>
                    <td>
                        <input id="cardNumber" name="cardNumber" placeholder="Credit card number" type="text">
                    </td>
                </tr>
                <tr>
                    <td>Exp Date</td>
                    <td>
                        <input id="expDate" name="expDate" placeholder="Enter expiration date" type="text">
                    </td>
                </tr>
                <tr>
                    <td>Code CVV</td>
                    <td>
                        <input autocomplete="off" id="cvv" name="cvv" placeholder="Enter your code cvv"
                               type="password">
                    </td>
                </tr>
            </table>
        </div>

        <div>
            <div class="center-text">
                <p id="message"></p>
            </div>
            <div class="center">
                <input class="button" id="pay" type="submit" value="Pay">
            </div>
        </div>
    </form:form>
</div>

<script src="<c:url value="/assets/js/Payment.js"/>"></script>
<c:import url="/templates/Footer.jsp"/>