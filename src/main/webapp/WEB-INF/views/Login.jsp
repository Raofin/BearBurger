<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:import url="/templates/Header.jsp"/>

<div class="form-container">
    <form:form id="login-form" method="POST">
        <h2 class="login-form-title">Log In</h2>

        <fieldset>
            <div>
                <label for="username">Username or Email</label>
                <input autofocus class="form-input-box" id="username" name="username"
                       placeholder="Enter your username or email here" type="text">
            </div>
            <div>
                <label for="password">Password</label>
                <div class="show-password">
                    <span id="password-view">Show</span>
                </div>
                <input id="password" name="password" autocomplete="on" class="form-input-box"
                       placeholder="Enter your password here" type="password">
            </div>
            <div class="remember-me">
                <input id="remember" name="remember" type="checkbox"/>
                <label for="remember">Remember Me</label>
            </div>
        </fieldset>

        <div class="bottom">
            <div class="center-text">
                <p id="prompt-message"></p>
            </div>
            <div class="center">
                <input class="button" id="form-submit" type="submit" value="Login">
            </div>
            <div class="center-text bottom-text">
                New here? <a href="Register.jsp">Create an Account</a>
            </div>
        </div>
    </form:form>
</div>

<%--<script src="../../public/js/Logic.js"></script>--%>
<%--<script src="../../public/js/LoginValidate.js"></script>--%>
<c:import url="/templates/Footer.jsp"/>