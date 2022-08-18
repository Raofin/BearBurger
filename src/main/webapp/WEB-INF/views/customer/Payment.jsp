<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/templates/Header.jsp"/>

<div class="form-container" id="payment-form">
    <form class="" method="POST">
        <div>
            <h1 class="payment-form-title"></h1>
            <p class="payment-description"></p>
            <p class="payment-price">
                Price: <span id="price" class="white-back-text"></span>
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
                    <td>Name</td>
                    <td>
                        <input autofocus id="name" name="name" placeholder="Enter your name" type="text">
                    </td>
                </tr>
                <tr>
                    <td>Card Number</td>
                    <td>
                        <input id="cardNumber" name="cardNumber" placeholder="Credit card number" type="text">
                    </td>
                </tr>
                <tr>
                    <td>Exp Date</td>
                    <td>
                        <input id="expDate" name="expDate" placeholder="Enter expiration date" type="text">
                    </td>
                </tr>
                <tr>
                    <td>Code CVV</td>
                    <td>
                        <input autocomplete="off" id="cvv" name="cvv" placeholder="Enter your code cvv"
                               type="password">
                    </td>
                </tr>
            </table>
        </div>

        <div>
            <div class="center-text">
                <p id="message"></p>
            </div>
            <div class="center">
                <input class="button" id="pay" type="submit" value="Pay">
            </div>
        </div>
    </form>
</div>

<script src="<c:url value="/assets/js/Payment.js"/>"></script>
<c:import url="/templates/Footer.jsp"/>