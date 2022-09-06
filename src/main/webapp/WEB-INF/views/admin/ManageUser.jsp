<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<c:import url="/resources/templates/AdminHeader.jsp"/>

<div class="manage-user-container">
    <form id="register-form" method="POST">
        <h2 class="admin-form-title">Manage Users</h2>
        <div class="table-wrapper">
            <table class="manage-users" id="users-table">
                <tr>
                    <th>UserID</th>
                    <th>Username</th>
                    <th>Email</th>
                    <th>Total Spent</th>
                    <th>Status</th>
                    <th colspan="2">Action</th>
                </tr>
            </table>
        </div>
    </form>
</div>

<script src="<c:url value="/resources/static/js/ManageUser.js"/>"></script>
<c:import url="/resources/templates/Footer.jsp"/>