<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<c:import url="/resources/templates/AdminHeader.jsp"/>

<div class="add-user-form">
    <form:form id="add-user-form" method="POST" modelAttribute="user">
        <h2 class="admin-form-title">Add User</h2>
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
        <p id="admin-prompt"></p>
        <div class="center">
            <input id="form-submit" type="submit" class="button" value="Add User">
        </div>
    </form:form>
</div>

<script src="<c:url value="/resources/static/js/Logic.js"/>"></script>
<script src="<c:url value="/resources/static/js/AddUser.js"/>"></script>
<c:import url="/resources/templates/Footer.jsp"/>