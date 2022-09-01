<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<c:import url="/templates/CustomerHeader.jsp"/>

<center>
    <div class="food-container">
        <h1 style="text-align: center">Search Your Favourite Foods!</h1>

        <form action="" method="post">
            <input class="search-input-box" id="search-box"
                   placeholder="Type anything to search"
                   spellcheck="false" type="text" onkeyup="searchFood(document.getElementById('search-box').value)" ><br><br>
        </form>
        <table id="foods-table"></table>
    </div>
</center>

<script src="<c:url value="/assets/js/FoodBox.js"/>"></script>
<script src="<c:url value="/assets/js/Search.js"/>"></script>
<c:import url="/templates/Footer.jsp"/>