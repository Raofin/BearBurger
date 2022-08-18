$('#login-form').validate({
    submitHandler: form => {
        $.ajax({
            url: '../controllers/LoginValidate.php',
            method: "POST",
            data: $('#login-form').serialize(),
            cache: false,
            processData: false,
            success: data => {
                let jsonData = JSON.parse(data);

                if (jsonData['success'] === true)
                    $(location).prop('href', 'Home.php');
                $('#prompt-message')
                    .html(jsonData['promptMessage'])
                    .addClass('error-message');
            }
        })
    },
    rules: {
        usernameOrEmail: {
            required: true,
            minlength: 4,
            maxlength: 30,
            normalizer: value => removeWhitespaces(value, '#usernameOrEmail')
        },
        password: {
            required: true,
            minlength: 6,
            maxlength: 15,
            normalizer: value => removeWhitespaces(value, '#password')
        }
    },
    messages: {
        usernameOrEmail: {
            required: "Please enter a username",
            minlength: "Your username or email must consist of at least 4 characters",
            maxlength: "Your username or email must be no more than 30 characters"
        },
        password: {
            required: "Please provide a password",
            minlength: "Your password must be at least 6 characters long",
            maxlength: "Your password must be no more than 15 characters long"
        }
    },
    errorClass: "form-input-error warning-message"
})