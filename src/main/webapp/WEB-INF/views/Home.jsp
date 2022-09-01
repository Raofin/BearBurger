<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<c:import url="/templates/CustomerHeader.jsp"/>

<div class="food-container">
    <h1 style="text-align: center">Order Your Favourite Foods!</h1>

    <form method="post">
        <h2 class="category-title" id="category-title">
            Category:
            <label onclick="fetchFoods('Burger')" id="Burger">Burger</label>
            <label onclick="fetchFoods('Pizza')" id="Pizza">Pizza</label>
            <label onclick="fetchFoods('Drinks')" id="Drinks">Drinks</label>
            <label onclick="fetchFoods('Coffee')" id="Coffee">Coffee</label>
            <label onclick="fetchFoods('Desert')" id="Desert">Desert</label>
            <label onclick="fetchFoods('Sides')" id="Sides">Sides</label>
        </h2>
    </form>
    <table id="foods-table"></table>
</div>

<script src="<c:url value="/assets/js/FoodBox.js"/>"></script>
<script src="<c:url value="/assets/js/Home.js"/>"></script>
<c:import url="/templates/Footer.jsp"/>