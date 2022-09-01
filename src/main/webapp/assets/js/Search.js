$(document).ready(() => searchFood(''))

function searchFood(title) {
    $.ajax({
        url: 'api/searchFoods?name=' + title,
        method: "GET",
        success: data => writeFoodHtml(data)
    });
}