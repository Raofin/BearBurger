$(document).ready(() => fetchFoods('Burger'))

function fetchFoods(category) {

    $.ajax({
        url: 'api/fetchFoods/' + category,
        method: "GET",
        success: data => writeFoodHtml(data)
    });

    $('label').removeClass('white-back-text');
    $('#' + category).addClass('white-back-text');
}
