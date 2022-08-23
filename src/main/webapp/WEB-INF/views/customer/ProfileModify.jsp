<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<c:import url="/templates/CustomerHeader.jsp"/>

<div class="center">
    <form:form action="profile-modify-action" class="form-user-profile" id="update-form" method="post" modelAttribute="user">
        <h1>User Profile</h1>
        <center>
            <table class="profile-table">
                <tr>
                    <td>Username:</td>
                    <td>${user.username}</td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><form:input type="text" path="email"/></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><form:input type="password" path="password"/></td>
                </tr>
                <tr>
                    <td>Phone:</td>
                    <td><form:input type="text" path="phoneNumber"/></td>
                </tr>
                <tr>
                    <td>Gender:</td>
                    <td>${user.gender}</td>
                </tr>
                <tr>
                    <td>Spent:</td>
                    <td>${user.spent} tk</td>
                </tr>
                <tr>
                    <td>Joined:</td>
                    <td>${user.regDateFormatted}</td>
                </tr>
            </table>
        </center>
        <div>
            <div class="center-text">
                <p id="message">
                    <% if (request.getParameter("error") != null)
                        out.print("<p class=\"error-message\">Please fill out all the fields properly.</p>");
                    %>
                </p>
            </div>
            <input class="button" id="confirm-button" type="submit" value="Confirm">
        </div>
    </form:form>
</div>

<%--<script src="<c:url value="/assets/js/ModifyValidate.js"/>"></script>--%>
<c:import url="/templates/Footer.jsp"/>