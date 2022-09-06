<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<c:import url="/resources/templates/CustomerHeader.jsp"/>

<div class="food-container">
    <h1>Order Your Favourite Foods!</h1>
    <h2 class="category-title" id="category-title">
        Category:
        <label onclick="fetchFoods('Burger')" id="Burger">Burger</label>
        <label onclick="fetchFoods('Pizza')" id="Pizza">Pizza</label>
        <label onclick="fetchFoods('Drinks')" id="Drinks">Drinks</label>
        <label onclick="fetchFoods('Coffee')" id="Coffee">Coffee</label>
        <label onclick="fetchFoods('Desert')" id="Desert">Desert</label>
        <label onclick="fetchFoods('Sides')" id="Sides">Sides</label>
    </h2>
    <table id="foods-table"></table>
</div>

<script src="<c:url value="/resources/static/js/FoodBox.js"/>"></script>
<script src="<c:url value="/resources/static/js/Home.js"/>"></script>
<c:import url="/resources/templates/Footer.jsp"/>