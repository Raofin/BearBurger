<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<c:import url="/templates/CustomerHeader.jsp"/>

<div class="form-container">
    <form:form id="login-form" method="POST">
        <h2 class="login-form-title">Log In</h2>

        <fieldset>
            <div>
                <label for="username">Username</label>
                <input autofocus class="form-input-box" id="username" name="username"
                       placeholder="Enter your username here" type="text">
            </div>
            <div>
                <label for="password">Password</label>
                <div class="show-password">
                    <span id="password-view">Show</span>
                </div>
                <input id="password" name="password" autocomplete="on" class="form-input-box"
                       placeholder="Enter your password here" type="password">
            </div>
                <%--<div class="remember-me">
                    <input id="remember" name="remember" type="checkbox"/>
                    <label for="remember">Remember Me</label>
                </div>--%>
        </fieldset>

        <div class="bottom">
            <div class="center-text">
                <p id="prompt-message">
                    <%
                        if (request.getParameter("error") != null) {
                            out.print("<p class=\"error-message\">Invalid username or password.</p>");
                        }

                        if (request.getParameter("regSuccess") != null) {
                            out.print("<p class=\"success\">Registration successful.</p>");
                        }
                    %>
                </p>
            </div>
            <div class="center">
                <input class="button" id="form-submit" type="submit" value="Login">
            </div>
            <div class="center-text bottom-text">
                New here? <a href="./register">Create an Account</a>
            </div>
        </div>
    </form:form>
</div>

<script src="<c:url value="/assets/js/Logic.js"/>"></script>
<script src="<c:url value="/assets/js/LoginValidate.js"/>"></script>
<c:import url="/templates/Footer.jsp"/>