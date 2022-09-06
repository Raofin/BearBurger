<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<c:import url="/resources/templates/AdminHeader.jsp"/>

<div class="admin-container" id="welcome">
    <div class="admin-items">
        <img class="admin-logo" src="<c:url value="/resources/static/img/admin-logo.svg"/>" alt="logo">
        <div class="admin-buttons">
            <h1 class="admin-title">Admin Panel</h1>
            <div><a href="./manage-roles"><button>Manage Roles</button></a></div>
            <div><a href="./add-user"><button>Add Users</button></a></div>
            <div><a href="./manage-user"><button>Manage Users</button></a></div>
            <div><a href="./add-food"><button>Add Foods</button></a></div>
            <div><a href="./manage-food"><button>Manage Foods</button></a></div>
        </div>
    </div>
</div>

<c:import url="/resources/templates/Footer.jsp"/>