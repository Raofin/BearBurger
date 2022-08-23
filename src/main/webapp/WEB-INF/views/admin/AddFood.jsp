<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<c:import url="/templates/AdminHeader.jsp"/>

<div class="add-user-form">
    <form:form id="register-form" method="POST" action="add-food-action" modelAttribute="food">
        <h2 class="admin-form-title">Add Foods</h2>
        <fieldset>
            <div>
                <div>
                    <label class="form-label" for="category">Category</label>
                    <form:select class="form-input-box" id="category" path="category">
                        <form:option value="Burger">Burger</form:option>
                        <form:option value="Pizza">Pizza</form:option>
                        <form:option value="Salad">Salad</form:option>
                        <form:option value="Pasta">Pasta</form:option>
                        <form:option value="Drinks">Drinks</form:option>
                        <form:option value="Coffee">Coffee</form:option>
                        <form:option value="Desert">Desert</form:option>
                        <form:option value="Sides">Sides</form:option>
                    </form:select>
                </div>
                <div>
                    <label class="form-label" for="food-name">Food Name</label>
                    <form:input class="form-input-box" id="food-name" name="food-name"
                                placeholder="Enter food name here" type="text" path="title"/>
                </div>
                <div>
                    <label class="form-label" for="price">Price</label>
                    <form:input class="form-input-box" id="price" name="price"
                                placeholder="Enter price here" type="text" path="price"/>
                </div>
                <div>
                    <label class="form-label" for="description">Description</label>
                    <form:textarea id="description" name="description" class="food-description"
                                   placeholder="Enter food description here" rows="4" path="description"/>
                </div>
            </div>
        </fieldset>

        <div class="admin-form-bottom">
            <div class="center-text">
                <p id="prompt-message">
                    <%
                        if (request.getParameter("error") != null) {
                            out.print("<p class=\"error-message\">Please fill out all the fields properly.</p>");
                        }
                        if (request.getParameter("added") != null) {
                            out.print("<p class=\"success\">New food added.</p>");
                        }
                    %>
                </p>
            </div>
            <div class="center">
                <input id="form-submit" type="submit" class="button" value="Add Food">
            </div>
        </div>
    </form:form>
</div>

<%--<script src="<c:url value="/assets/js/.js"/>"></script>--%>
<c:import url="/templates/Footer.jsp"/>