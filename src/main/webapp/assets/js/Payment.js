let form = document.querySelector('form');
let messageDiv = document.getElementById('message')
let priceId = document.getElementById('price');
let price = priceId.innerText.slice(0, -2); // remove 'tk'
let takaId = document.getElementById('taka');
let dollarId = document.getElementById('dollar');
let poundId = document.getElementById('pound');
let paid = false;

takaId.addEventListener('click',
    function (event) {
        event.preventDefault();
        priceId.innerText = price + 'tk';

        takaId.classList.add('white-back-text');
        dollarId.classList.remove('white-back-text');
        poundId.classList.remove('white-back-text');
    },
    false);

dollarId.addEventListener('click',
    function (event) {
        event.preventDefault();
        priceId.innerText = '$' + (price * 0.011).toFixed(2);

        takaId.classList.remove('white-back-text');
        dollarId.classList.add('white-back-text');
        poundId.classList.remove('white-back-text');
    },
    false);

poundId.addEventListener('click',
    function (event) {
        event.preventDefault();
        priceId.innerText = "£" + (price * 0.0089).toFixed(2);

        takaId.classList.remove('white-back-text');
        dollarId.classList.remove('white-back-text');
        poundId.classList.add('white-back-text');
    },
    false);

form.addEventListener('submit', function (event) {
    event.preventDefault();

    if (paid) {
        location.href = '../home';
        return;
    }

    let name = document.getElementById('name');
    let cardNumber = document.getElementById('cardNumber');
    let expDate = document.getElementById('expDate');
    let cvv = document.getElementById('cvv');

    if (name.value === '') name.classList.add('form-input-error');
    else name.classList.remove('form-input-error');

    if (cardNumber.value === '') cardNumber.classList.add('form-input-error');
    else cardNumber.classList.remove('form-input-error');

    if (expDate.value === '') expDate.classList.add('form-input-error');
    else expDate.classList.remove('form-input-error');

    if (cvv.value === '') cvv.classList.add('form-input-error');
    else cvv.classList.remove('form-input-error');

    if (name.value !== '' && cardNumber.value !== '' && expDate.value !== '' && cvv.value !== '') {
        document.getElementById('pay').value = 'Go Back';
        paid = true;
        messageDiv.innerHTML = '';
        messageDiv.innerHTML += '<p class="success center-text center-text">Payment Successful.</p>';
        name.value = cardNumber.value = expDate.value = cvv.value = '';
        this.submit();
    } else {
        messageDiv.innerHTML = '';
        messageDiv.innerHTML += '<p class="error-message center-text">Please fill out all the fields.</p>';
    }
});
