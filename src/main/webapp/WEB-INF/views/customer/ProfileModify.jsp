<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<c:import url="/templates/CustomerHeader.jsp"/>

<div class="center">
    <form:form action="profile-modify-action" class="form-user-profile" id="update-form" method="post" modelAttribute="user">
        <h1>User Profile</h1>
        <table class="profile-table">
            <tr>
                <td>Username:</td>
                <td>${user.username}</td>
            </tr>
            <tr>
                <td><label for="email">Email:</label></td>
                <td><form:input id="email" name="email" path="email" maxlength="30"
                                placeholder="Enter your email here" type="text"/></td>
            </tr>
            <tr>
                <td><label for="password">Password:</label></td>
                <td><form:input id="password" name="password" path="password" maxlength="30"
                                placeholder="Enter a new password here" type="password"/></td>
            </tr>
            <tr>
                <td><label for="phoneNumber">Phone:</label></td>
                <td><form:input id="phoneNumber" name="phoneNumber" path="phoneNumber" maxlength="14"
                                placeholder="Enter phone number here" type="text"/></td>
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

<script src="<c:url value="/assets/js/Logic.js"/>"></script>
<script src="<c:url value="/assets/js/ModifyValidate.js"/>"></script>
<c:import url="/templates/Footer.jsp"/>