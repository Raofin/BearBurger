$('#add-user-form').validate({
    submitHandler: form => {
        $.ajax({
            url: 'api/v1/admin/add-user-action',
            method: "POST",
            data: $('#add-user-form').serialize(),
            success: data => {
                let message = document.getElementById('admin-prompt');

                if (data === 'error')
                    message.innerHTML = '<p class="tomato-text">Please fill out all the fields properly.</p>'
                else if (data === 'duplicate')
                    message.innerHTML = '<p class="tomato-text">Another account with that username already exists.</p>'
                else {
                    message.innerHTML = '<p class="green-text">New user added!</p>'
                    $('#add-user-form').trigger("reset");
                }
            }
        })
    },
    rules: {
        username: {
            required: true,
            minlength: 4,
            maxlength: 15,
            normalizer: value => removeWhitespaces(value, '#username')
        },
        email: {
            required: true,
            // email: true,
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
        gender: {
            required: true
        },
    },
    messages: {
        username: {
            required: "Please enter a username",
            minlength: "Your username must consist of at least 4 characters",
            maxlength: "Your username must be no more than 15 characters long"
        },
        email: {
            required: "Please enter email address",
            maxlength: "Your email must be no more than 30 characters long"
        },
        password: {
            required: "Please provide a password",
            minlength: "Your password must be at least 6 characters long",
            maxlength: "Your password must be no more than 30 characters long"
        },
        phoneNumber: {
            required: "Please enter phone number",
            minlength: "Your phone number must be at least 6 characters long",
            maxlength: "Your phone number must be no more than 14 characters long"
        },
        gender: "Please select your gender",
    },
    errorClass: "form-input-error warning-message",
    errorPlacement: function (error, element) {
        if (element.attr("type") === "radio") {
            error.insertAfter('#radio-button-box');
            $('#radio-button-box').addClass('form-input-error');
        } else error.insertAfter(element);
    }
})

$('input[type=radio][name=gender]').change(() =>
    $('#radio-button-box').removeClass('form-input-error'));