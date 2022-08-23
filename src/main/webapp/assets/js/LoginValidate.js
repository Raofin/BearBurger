$('#login-form').validate({
    submitHandler: form => {
        $.ajax({
            // url: '../controllers/LoginValidate.php',
            method: "POST",
            data: $('#login-form').serialize(),
            cache: false,
            processData: false,
            success: document.getElementById('#login-form').submit()
        })
    },
    rules: {
        username: {
            required: true,
            minlength: 4,
            maxlength: 30,
            normalizer: value => removeWhitespaces(value, '#username')
        },
        password: {
            required: true,
            minlength: 4,
            maxlength: 15,
            normalizer: value => removeWhitespaces(value, '#password')
        }
    },
    messages: {
        username: {
            required: "Please enter a username",
            minlength: "Your username must consist of at least 4 characters",
            maxlength: "Your username must be no more than 30 characters"
        },
        password: {
            required: "Please provide a password",
            minlength: "Your password must be at least 4 characters long",
            maxlength: "Your password must be no more than 15 characters long"
        }
    },
    errorClass: "form-input-error warning-message"
})