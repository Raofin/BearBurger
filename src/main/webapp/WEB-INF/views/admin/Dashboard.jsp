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

<div class="admin-container" id="welcome">
    <h1 class="admin-title">Admin Dashboard</h1>
    <div class="admin-items">
        <img class="admin-logo" src="<c:url value="/assets/img/admin-logo.svg"/>" alt="logo">
        <div class="admin-buttons">
            <div><button onmousedown="location.href='/admin/manageUser'">Manage User</button></div>
            <div><button onmousedown="location.href='/admin/addUser'">Add User</button></div>
            <div><button onmousedown="location.href='/admin/addFood'">Add Foods</button></div>
            <div><button onmousedown="location.href=''">Purchase Log</button></div>
        </div>
    </div>
</div>

</body>

<footer class="footer">
    <p>Copyright © 2022 by <a href="https://raofin.net">Raofin</a>. All Rights Reserved.</p>
</footer>

</html>
