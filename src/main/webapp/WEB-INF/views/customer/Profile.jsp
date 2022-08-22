<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<c:import url="/templates/CustomerHeader.jsp"/>

<div class="center">
    <form class="form-user-profile" method="post">
        <h1>User Profile</h1>
        <center>
            <table>
                <tr>
                    <td>Username:</td>
                    <td><?php echo $_SESSION['username'] ?></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><?php echo $_SESSION['email'] ?></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><?php echo $_SESSION['password'] ?></td>
                </tr>
                <tr>
                    <td>Phone:</td>
                    <td><?php echo $_SESSION['phone'] ?></td>
                </tr>
                <tr>
                    <td>Gender:</td>
                    <td><?php echo $_SESSION['gender'] ?></td>
                </tr>
                <tr>
                    <td>Spent:</td>
                    <td><?php echo $_SESSION['spent'] ?> tk</td>
                </tr>
                <tr>
                    <td>Joined:</td>
                    <td><?php echo date('F j, Y', strtotime($_SESSION['joined'])) ?></td>
                </tr>
            </table>
        </center>
        <div class="center-text">
            <p id="message"></p>
        </div>
        <input type="submit" value="Modify Details" class="button" style="margin: 0;">
    </form>
</div>

<%--<script src="<c:url value="/assets/js/.js"/>"></script>--%>
<c:import url="/templates/Footer.jsp"/>