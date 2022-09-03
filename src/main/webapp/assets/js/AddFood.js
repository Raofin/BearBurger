$(document).ready(() => $('#price').val(''));

$('#price').keypress(e => !String.fromCharCode(e.which).match(/\D/g));

$('#add-food-form').validate({
    rules: {
        "food-name": {
            required: true,
            minlength: 5,
            maxlength: 30,
        },
        price: {
            required: true,
            min: 50,
            max: 10000,
        },
        description: {
            required: true,
            minlength: 10,
            maxlength: 10000,
        }
    },
    messages: {
        "food-name": {
            required: "Please enter a food title",
            minlength: "Food title must consist of at least 5 characters",
            maxlength: "Food title must be no more than 30 characters long"
        },
        price: {
            required: "Please enter a price",
            min: "Price must be at least 50tk",
            max: "Price must be no more than 10000tk!"
        },
        description: {
            required: "Please provide a description",
            minlength: "Description must be at least 10 characters long",
            maxlength: "Description must be no more than 10,000 characters long"
        }
    },
    errorClass: "form-input-error warning-message"
})




