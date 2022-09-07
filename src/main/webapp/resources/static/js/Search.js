let search = $('#search-input');

$(document).ready(() => searchFood());

search.keyup(() => searchFood());

function searchFood() {
    $.ajax({
        url: 'api/v1/search-foods-by-name?name=' + search.val(),
        method: "GET",
        success: data => {

            if (data.length === 0) {

                document.getElementById('foods-table').innerHTML = "<p class='not-found'>" + search.val() + " not available!</p>";
                return;
            }

            writeFoodHtml(data);
        }
    });
}