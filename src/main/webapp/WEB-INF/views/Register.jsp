<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<c:import url="/templates/CustomerHeader.jsp"/>

<div class="form-container">
    <form:form id="register-form" action="register-action" method="POST" modelAttribute="user">
        <h2 class="login-form-title">Create an Account</h2>

        <fieldset>
            <div>
                <div>
                    <label class="form-label" for="username">Username</label>
                    <form:input class="form-input-box" id="username"
                                name="username" placeholder="Enter your username here" path="username"/>
                </div>
                <div>
                    <label class="form-label" for="email">Email</label>
                    <form:input class="form-input-box" id="email" name="email"
                                placeholder="Enter your email here" path="email"/>
                </div>
                <div>
                    <label class="form-label" for="password">Password</label>
                    <div class="show-password"><span id="password-view">Show</span></div>
                    <form:input autocomplete="off" class="form-input-box" id="password" path="password"
                                placeholder="Enter your password here" type="password"/>
                </div>
                <div>
                    <label class="form-label" for="cPassword">Confirm Password</label>
                    <form:input autocomplete="off" class="form-input-box" id="cPassword" path="cPassword"
                                placeholder="Enter your password here" type="password"/>
                </div>
                <div>
                    <label class="form-label" for="phone">Phone Number</label>
                    <form:input class="form-input-box" id="phone" path="phoneNumber"
                                placeholder="Enter your phone number here" type="text"/>
                </div>
                <div>
                    <label>Gender</label>
                    <div class="radio-button" id="radio-button-box">
                        <form:radiobutton id="male" path="gender" value="Male"/>
                        <label class="radio-label" for="male">Male</label>
                        <form:radiobutton id="female" path="gender" value="Female"/>
                        <label class="radio-label" for="female">Female</label>
                    </div>
                </div>
            </div>
        </fieldset>

        <div class="bottom">
            <div class="center-text">
                <p id="prompt-message">
                    <% if (request.getParameter("error") != null)
                        out.print("<p class=\"error-message\">Please fill out all the fields properly.</p>");
                    %>
                </p>
            </div>
            <div class="center">
                <input id="form-submit" type="submit" class="button" value="Register">
            </div>
            <div class="center-text bottom-text">
                Already have an account? <a href="Login.jsp">Login</a>
            </div>
        </div>
    </form:form>
</div>

<%--<script src="../../public/js/Logic.js"></script>--%>
<%--<script src="../../public/js/RegistrationValidate.js"></script>--%>
<c:import url="/templates/Footer.jsp"/>