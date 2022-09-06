<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page isELIgnored="false" %>
<c:import url="/resources/templates/CustomerHeader.jsp"/>

<div class="form-container">
    <form:form action="api/payment-action" id="payment-form" method="GET">
        <div>
            <h1 class="payment-form-title">${food.title}</h1>
            <p class="payment-description">${food.description}</p>
            <p class="payment-price">
                Price: <span id="price" class="white-back-text">${food.price}tk</span>
            </p>
        </div>
        <div class="currency-text">
            <h3 class="">Pay with:
                <a id="taka" class="white-back-text">Taka</a>
                <a id="dollar">Dollar</a>
                <a id="pound">Pound</a>
            </h3>
        </div>
        <div>
            <h2 class="payment-title">Payment</h2>
            <table class="payment-table">
                <tr>
                    <td><label for="name">Name</label></td>
                    <td><input id="name" name="name" placeholder="Enter your name" type="text"
                               value="<sec:authentication property="principal.username"/>">
                    </td>
                </tr>
                <tr>
                    <td><label for="card-number">Card Number</label></td>
                    <td><input autofocus id="card-number" name="cardNumber" placeholder="0000 0000 0000 0000" type="text"></td>
                </tr>
                <tr>
                    <td><label for="exp-date">Exp Date</label></td>
                    <td><input id="exp-date" maxlength="5" name="expDate" placeholder="MM/YY" type="text" ></td>
                </tr>
                <tr>
                    <td><label for="cvv">Code CVV</label></td>
                    <td><input id="cvv" maxlength="3" name="cvv" placeholder="***" type="password"></td>
                </tr>
            </table>
        </div>
        <div>
            <div class="center-text"><p id="message"></p></div>
            <div class="center">
                <input class="button" id="pay" type="submit" value="Pay">
            </div>
        </div>
    </form:form>
</div>

<script src="<c:url value="/resources/static/js/Payment.js"/>"></script>
<c:import url="/resources/templates/Footer.jsp"/>