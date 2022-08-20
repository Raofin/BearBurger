<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/templates/AdminHeader.jsp"/>

    <div class="add-user-form">
        <form id="register-form" method="POST">
            <h2 class="admin-form-title">Add Foods</h2>
            <fieldset>
                <div>
                    <div>
                        <label class="form-label" for="category">Category</label>
                        <select class="form-input-box" id="category">
                            <option value="Burger">Burger</option>
                            <option value="Pizza">Pizza</option>
                            <option value="Salad">Salad</option>
                            <option value="Pasta">Pasta</option>
                            <option value="Drinks">Drinks</option>
                            <option value="Coffee">Coffee</option>
                            <option value="Desert">Desert</option>
                            <option value="Sides">Sides</option>
                        </select>
                    </div>
                    <div>
                        <label class="form-label" for="food-name">Food Name</label>
                        <input class="form-input-box" id="food-name" name="food-name"
                               placeholder="Enter food name here" type="text">
                    </div>
                    <div>
                        <label class="form-label" for="price">Price</label>
                        <input class="form-input-box" id="price" name="price"
                               placeholder="Enter price here" type="text">
                    </div>
                    <div>
                        <label class="form-label" for="description">Description</label>
                        <textarea id="description" name="description" class="food-description"
                                  placeholder="Enter food description here" rows="4"></textarea>
                    </div>
                </div>
            </fieldset>

            <div class="admin-form-bottom">
                <div class="center-text">
                    <p id="prompt-message"></p>
                </div>
                <div class="center">
                    <input id="form-submit" type="submit" class="button" value="Add Food">
                </div>
            </div>
        </form>
    </div>

<%--<script src="<c:url value="/assets/js/.js"/>"></script>--%>
<c:import url="/templates/Footer.jsp"/>