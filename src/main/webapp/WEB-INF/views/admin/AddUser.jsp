<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<c:import url="/templates/AdminHeader.jsp"/>

    <div class="add-user-form">
        <form id="register-form" method="POST">
            <h2 class="login-form-title">Add User</h2>

            <fieldset>
                <div>
                    <div>
                        <label class="form-label" for="username">Username</label>
                        <input autofocus class="form-input-box" id="username"
                               name="username" placeholder="Enter your username here" type="text">
                    </div>
                    <div>
                        <label class="form-label" for="email">Email</label>
                        <input class="form-input-box" id="email" name="email"
                               placeholder="Enter your email here" type="text">
                    </div>
                    <div>
                        <label class="form-label" for="password">Password</label>
                        <div class="show-password">
                            <span id="password-view">Show</span>
                        </div>
                        <input autocomplete="off" class="form-input-box" id="password" name="password"
                               placeholder="Enter your password here" type="password">
                    </div>
                    <div>
                        <label class="form-label" for="phone">Phone Number</label>
                        <input class="form-input-box" id="phone" name="phone"
                               placeholder="Enter your phone number here" type="text">
                    </div>
                    <div>
                        <label>Gender</label>
                        <div class="radio-button" id="radio-button-box">
                            <input id="male" name="gender" type="radio" value="Male">
                            <label class="radio-label" for="male">Male</label>
                            <input id="female" name="gender" type="radio" value="Female">
                            <label class="radio-label" for="female">Female</label>
                        </div>
                    </div>
                </div>
            </fieldset>

            <div class="bottom">
                <div class="center-text">
                    <p id="prompt-message"></p>
                </div>
                <div class="center">
                    <input id="form-submit" type="submit" class="button" value="Add User">
                </div>
            </div>
        </form>
    </div>

<%--<script src="<c:url value="/assets/js/.js"/>"></script>--%>
<c:import url="/templates/Footer.jsp"/>