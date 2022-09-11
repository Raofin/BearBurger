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
    <a class="logo" href="./home"><img src="<c:url value="/resources/static/img/nav-logo.svg"/>" alt="logo"></a>
    <nav>
        <ul class="nav-links">
            <li><a href="./home">Home</a></li>
            <li><a href="https://github.com/Raofin/BearBurger">GitHub</a></li>
            <li><a href="https://raofin.net">raofin.net</a></li>
        </ul>
    </nav>
</header>

<div class="center">
    <div class="form-container" id="project-details">
        <div class="project-details-img center">
            <img class="logo" src="<c:url value="/resources/static/img/nav-logo.svg"/>" alt="logo">
        </div>
        <div class="project-link">
            <a href="https://github.com/Raofin/BearBurger">github.com/Raofin/BearBurger</a>
        </div>
        <div class="project-details">
            BearBurger is a web based food management system, built using Spring MVC, Spring Security, Hibernate
            with MySQL and Maven to manage the dependencies.
            <h2>Features</h2>
            <hr>
            <h4>Customers can browse foods, view details, and explore many other things. However, in order to make a purchase
                or interact with anything, he must first log in to the system. There are also various features available
                for administrators. The application is essentially separated into two roles-</h4>
            <h3>Customer:</h3>
            <ul>
                <li>Login</li>
                <li>Registration</li>
                <li>Profile view and modify</li>
                <li>Browse and search foods</li>
                <li>Purchase foods</li>
                <li>Payment with credit card</li>
                <li>Post comments and replies on each food</li>
            </ul>
            <h3>Administrator:</h3>
            <ul>
                <li>Manage user roles</li>
                <li>Add, remove, and disable users</li>
                <li>View user and food list</li>
                <li>Manage foods</li>
            </ul>
            <h2>Tools</h2>
            <hr>
            <h4>Tools and technologies used to develop the project-</h4>
            <ul>
                <li>Java, HTML, CSS, JavaScript & jQuery</li>
                <li><b>Frameworks: </b>Spring MVC, Spring Security & Hibernate</li>
                <li><b>Database: </b>MySQL</li>
                <li><b>Server: </b>Apache Tomcat</li>
                <li><b>IDE: </b>IntelliJ IDEA</li>
            </ul>
        </div>
        <div class="raofin">
            <img src="<c:url value="/resources/static/img/me.jpg"/>" alt="raofin">
            <div>
                <p>Developed By <a href="https://raofin.net">Raofin</a></p>
                <p>Email: <a href="mailto:hello@raofin.net">hello@raofin.net</a></p>
                <p>Website: <a href="https://raofin.net">raofin.net</a></p>
                <p>Github: <a href="https://github.com/Raofin">github.com/Raofin</a></p>
            </div>
        </div>
    </div>
</div>

</body>

<footer class="footer">
    <p>Copyright &copy 2022 by <a href="https://raofin.net">Raofin</a>. All Rights Reserved.</p>
</footer>

</html>