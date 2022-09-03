<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<c:import url="/templates/AdminHeader.jsp"/>

<div class="add-user-form">
    <form:form id="add-user-form" method="POST" action="add-user-action" modelAttribute="user" >
        <h2 class="login-form-title">Add User</h2>
        <fieldset>
            <div>
                <div>
                    <label class="form-label" for="username">Username</label>
                    <form:input class="form-input-box" id="username"
                                name="username" placeholder="Enter your username here" type="text" path="username"/>
                </div>
                <div>
                    <label class="form-label" for="email">Email</label>
                    <form:input class="form-input-box" id="email" name="email"
                                placeholder="Enter your email here" type="text" path="email"/>
                </div>
                <div>
                    <label class="form-label" for="password">Password</label>
                    <form:input autocomplete="off" class="form-input-box" id="password" name="password"
                                placeholder="Enter your password here" type="password" path="password"/>
                </div>
                <div>
                    <label class="form-label" for="phone">Phone Number</label>
                    <form:input class="form-input-box" id="phone" name="phoneNumber"
                                placeholder="Enter your phone number here" type="text" path="phoneNumber"/>
                </div>
                <div>
                    <label>Gender</label>
                    <div class="radio-button" id="radio-button-box">
                        <form:radiobutton id="male" name="gender" value="Male" path="gender"/>
                        <label class="radio-label" for="male">Male</label>
                        <form:radiobutton id="female" name="gender" value="Female" path="gender"/>
                        <label class="radio-label" for="female">Female</label>
                    </div>
                </div>
            </div>
        </fieldset>

        <div class="bottom">
            <div class="center-text">
                <p id="prompt-message">
                    <%
                        if (request.getParameter("error") != null) {
                            out.print("<p class=\"error-message\">Please fill out all the fields properly.</p>");
                        }
                        if (request.getParameter("duplicate") != null) {
                            out.print("<p class=\"error-message\">Another account with that username already exists.</p>");
                        }
                        if (request.getParameter("added") != null) {
                            out.print("<p class=\"success\">New user added!</p>");
                        }
                    %>
                </p>
            </div>
            <div class="center">
                <input id="form-submit" type="submit" class="button" value="Add User">
            </div>
        </div>
    </form:form>
</div>

<script src="<c:url value="/assets/js/Logic.js"/>"></script>
<script src="<c:url value="/assets/js/AddUser.js"/>"></script>
<c:import url="/templates/Footer.jsp"/>