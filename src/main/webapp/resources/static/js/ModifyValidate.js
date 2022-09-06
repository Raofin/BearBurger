$('#update-form').validate({
    rules: {
        email: {
            required: true,
            emailRegex: true,
            minlength: 6,
            maxlength: 30,
            normalizer: value => removeWhitespaces(value, '#email')
        },
        password: {
            required: true,
            minlength: 6,
            maxlength: 30,
            normalizer: value => removeWhitespaces(value, '#password')
        },
        phoneNumber: {
            required: true,
            phoneRegex: true,
            minlength: 6,
            maxlength: 14,
            normalizer: value => removeWhitespaces(value, '#phone'),
        },
    },
    messages: {
        email: {
            required: "Please enter email address",
            maxlength: "Your email must be no more than 30 characters long"
        },
        password: {
            required: "Please provide a password",
            minlength: "Password must be at least 6 characters long",
            maxlength: "Password must be no more than 30 characters long"
        },
        phoneNumber: {
            required: "Please enter phone number",
            minlength: "Must be at least 6 characters long",
            maxlength: "Must be no more than 14 characters long"
        },
    },
    errorClass: "form-input-error warning-message"
})