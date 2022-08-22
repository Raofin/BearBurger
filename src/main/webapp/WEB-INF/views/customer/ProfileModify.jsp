<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<c:import url="/templates/CustomerHeader.jsp"/>

<div class="center">
    <form class="form-user-profile" id="update-form" method="post">
        <h1>User Profile</h1>
        <center>
            <table>
                <tr>
                    <td>Username:</td>
                    <td><input type="text" id="username" name="username"
                               value="<?php echo $_SESSION['username'] ?>"></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input type="text" id="email" name="email" value="<?php echo $_SESSION['email'] ?>"></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" id="password" name="password"
                               value="<?php echo $_SESSION['password'] ?>"></td>
                </tr>
                <tr>
                    <td>Phone:</td>
                    <td><input type="text" id="phone" name="phone" value="<?php echo $_SESSION['phone'] ?>"></td>
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
        <div>
            <div class="center-text">
                <p id="message"></p>
            </div>
            <?php if ($_SERVER['REQUEST_METHOD'] === 'POST') update() ?>
            <input type="submit" value="Update" class="button" style="margin: 0;">
        </div>

    </form>
</div>

<%--<script src="<c:url value="/assets/js/.js"/>"></script>--%>
<c:import url="/templates/Footer.jsp"/>