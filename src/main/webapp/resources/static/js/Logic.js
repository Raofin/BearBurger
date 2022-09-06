function removeWhitespaces(value, id) {
    value = value.replace(/\s/g, ''); // remove whitespaces
    $(id).val(value);
    return $.trim(value);
}

$.validator.addMethod(
    'emailRegex',
    function (value, element) {
        return this.optional(element)
            || /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(value);
    },
    'Please enter a valid email address.');

$.validator.addMethod(
    'phoneRegex',
    function (value, element) {
        return this.optional(element)
            || /^(?:(?:\+|0{0,2})91(\s*[\ -]\s*)?|[0]?)?[456789]\d{9}|(\d[ -]?){10}\d$/.test(value);
    },
    'Please enter a valid phone number.');

$('#password-view').click(() => {
    if ($('#password-view').text() === 'Show') {
        $('#password, #cPassword').prop('type', 'text');
        $('#password-view').html('Hide');
    } else {
        $('#password, #cPassword').prop('type', 'password');
        $('#password-view').html('Show');
    }
})