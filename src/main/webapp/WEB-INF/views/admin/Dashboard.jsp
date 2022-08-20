<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/templates/AdminHeader.jsp"/>

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

<%--<script src="<c:url value="/assets/js/.js"/>"></script>--%>
<c:import url="/templates/Footer.jsp"/>