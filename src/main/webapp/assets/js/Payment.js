let paid = false;
let message = document.getElementById('message');
let payButton = document.getElementById('pay')
let priceLabel = document.getElementById('price');
let price = priceLabel.innerText.slice(0, -2); // remove 'tk'

$('#payment-form').validate({
    submitHandler: function (form, event) {
        event.preventDefault();

        if (paid) {
            location.href = './home';
            return;
        }

        $.ajax({
            url: 'api/payment-action',
            method: "GET",
            success: data => {
                payButton.value = 'Go Back';
                paid = true;
                message.innerHTML = '<p class="success center-text center-text">Payment Successful.</p>';
            }
        })
    },
    rules: {
        name: {
            required: true,
            minlength: 4,
            maxlength: 30,
        },
        cardNumber: {
            required: true,
            minlength: 19,
            maxlength: 19,
        },
        expDate: {
            required: true,
            minlength: 5,
            maxlength: 5,
        },
        cvv: {
            required: true,
            minlength: 3,
            maxlength: 3,
        }
    },
    messages: {
        name: {
            minlength: "Card name must be at least 4 characters long",
            maxlength: "Card name must be no more than 30 characters"
        },
        cardNumber: {
            minlength: "Please this field properly",
            maxlength: "Please this field properly"
        },
        expDate: {
            minlength: "Please this field properly",
            maxlength: "Please this field properly"
        },
        cvv: {
            minlength: "Please this field properly",
            maxlength: "Please this field properly"
        }
    },
    errorClass: "form-input-error warning-message"
})

// Payment input events

$("#card-number").on("keydown", function (e) {
    const cursor = this.selectionStart;
    if (this.selectionEnd !== cursor) return;
    if (e.which === 46) {
        if (this.value[cursor] === " ") this.selectionStart++;
    } else if (e.which === 8) {
        if (cursor && this.value[cursor - 1] === " ") this.selectionEnd--;
    }
}).on("input", function () {
    let value = this.value;
    let cursor = this.selectionStart;
    const matches = value.substring(0, cursor).match(/[^0-9]/g);
    if (matches) cursor -= matches.length;
    value = value.replace(/[^0-9]/g, "").substring(0, 16);
    let formatted = "";
    for (let i = 0, n = value.length; i < n; i++) {
        if (i && i % 4 === 0) {
            if (formatted.length <= cursor) cursor++;
            formatted += " ";
        }
        formatted += value[i];
    }
    if (formatted === this.value) return;
    this.value = formatted;
    this.selectionEnd = cursor;
});

$('#exp-date, #cvv').keypress(e => !String.fromCharCode(e.which).match(/\D/g));

$("#exp-date").on("keydown", e => {
    e.target.value = e.target.value
        .replace(/^([1-9]\/|[2-9])$/g, '0$1/')
        .replace(/^(0[1-9]|1[0-2])$/g, '$1/')
        .replace(/^([0-1])([3-9])$/g, '0$1/$2')
        .replace(/^(0?[1-9]|1[0-2])([0-9]{2})$/g, '$1/$2')
        .replace(/^([0]+)\/|[0]+$/g, '0')
        .replace(/[^\d\/]|^[\/]*$/g, '')
        .replace(/\/\//g, '/');
})

// Currency click events

$('#taka').click(() => {
    priceLabel.innerText = price + 'tk';
    $('#taka').addClass('white-back-text')
    $('#dollar, #pound').removeClass('white-back-text');
})

$('#dollar').click(() => {
    priceLabel.innerText = '$' + (price * 0.011).toFixed(2);
    $('#dollar').addClass('white-back-text')
    $('#taka, #pound').removeClass('white-back-text');
});

$('#pound').click(() => {
    priceLabel.innerHTML = "&#163;" + (price * 0.0089).toFixed(2);
    $('#pound').addClass('white-back-text')
    $('#taka, #dollar').removeClass('white-back-text');
})