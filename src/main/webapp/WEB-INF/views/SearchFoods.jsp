<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<c:import url="/resources/templates/CustomerHeader.jsp"/>

<div class="food-container">
    <h1><label for="search-input">Search Foods</label></h1>
    <input autofocus class="search-input-box" id="search-input" spellcheck="false"
           type="text" placeholder="Type anything to search">
    <table id="foods-table"></table>
</div>

<script src="<c:url value="/resources/static/js/FoodBox.js"/>"></script>
<script src="<c:url value="/resources/static/js/Search.js"/>"></script>
<c:import url="/resources/templates/Footer.jsp"/>