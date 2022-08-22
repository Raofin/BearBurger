<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<c:import url="/templates/CustomerHeader.jsp"/>

<center>
    <div class="food-container">
        <h1 style="text-align: center">Order Your Favourite Foods!</h1>

        <form action="" method="post">
            <input class="search-input-box" id="search-box"
                   placeholder="Type anything to search"
                   spellcheck="false" type="text"><br><br>
        </form>
        <table id="foods-table"></table>
    </div>
</center>

<%--<script src="<c:url value="/assets/js/.js"/>"></script>--%>
<c:import url="/templates/Footer.jsp"/>