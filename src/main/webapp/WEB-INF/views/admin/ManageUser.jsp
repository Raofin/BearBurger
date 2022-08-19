<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/templates/Header.jsp"/>

<div class="manage-user-container">
        <form id="register-form" method="POST">
            <h2 class="admin-form-title">Manage Users</h2>
            <div class="table-wrapper">
                <table>
                    <tr>
                        <th>UserID</th>
                        <th>Username</th>
                        <th>Email</th>
                        <th>Total Spent</th>
                        <th>Action</th>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>Raofin</td>
                        <td>hello@raofin.net</td>
                        <td>$6900</td>
                        <td>
                            <a href="">Disable</a>
                            <a href="">Delete</a>
                        </td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>Raofin</td>
                        <td>hello@raofin.net</td>
                        <td>$6900</td>
                        <td>
                            <a href="">Disable</a>
                            <a href="">Delete</a>
                        </td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>Raofin</td>
                        <td>hello@raofin.net</td>
                        <td>$6900</td>
                        <td>
                            <a href="">Disable</a>
                            <a href="">Delete</a>
                        </td>
                    </tr>
                </table>
            </div>
        </form>

        <div>
            <button class="admin-form-bottom button" onmousedown="location.href='/admin/dashboard'">Back</button>
        </div>
    </div>

<%--<script src="<c:url value="/assets/js/.js"/>"></script>--%>
<c:import url="/templates/Footer.jsp"/>