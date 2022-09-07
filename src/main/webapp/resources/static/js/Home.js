$(document).ready(() => fetchFoods('Burger'))

function fetchFoods(category) {

    $.ajax({
        url: 'api/v1/fetch-foods-by-category/' + category,
        method: "GET",
        success: data => {

            if (data.length === 0) {
                document.getElementById('foods-table').innerHTML = "<p class='not-found'>No foods available in this category.</p>";
                return;
            }

            writeFoodHtml(data);
        }
    });

    $('label').removeClass('white-back-text');
    $('#' + category).addClass('white-back-text');
}
