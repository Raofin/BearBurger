<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<c:import url="/templates/AdminHeader.jsp"/>

<div class="manage-user-container">
    <form id="register-form" method="POST">
        <h2 class="admin-form-title">Manage Roles</h2>
        <div class="table-wrapper">
            <table id="users-table">
                <tr>
                    <th>UserID</th>
                    <th>Username</th>
                    <th>Email</th>
                    <th>Roles</th>
                    <th>Action</th>
                </tr>
            </table>
        </div>
    </form>

</div>
<script src="${pageContext.request.contextPath}/assets/js/ManageRoles.js"></script>
<c:import url="/templates/Footer.jsp"/>