$(document).ready(() => fetchAllFoods())

function fetchAllFoods() {

    $.getJSON("api/fetchAllFoods",
        data => {
            let foods = '';

            $.each(data, (key, value) => {
                foods +=
                    '<tr id="food' + value['foodID'] + '" >' +
                    '    <td>' + value['foodID'] + '</td> ' +
                    '    <td>' + value['category'] + '</td> ' +
                    '    <td>' + value['title'] + '</td> ' +
                    '    <td>' + value['price'] + '</td> ' +
                    '    <td> ' +
                    '        <a class="red-text" onclick="' + 'deleteFood(' + value['foodID'] + ')">Delete</a> ' +
                    '    </td>' +
                    '</tr>';
            })

            $('#foods-table').append(foods);
        }
    )
}

function deleteFood(id) {

    $.ajax({
        url: 'api/delete-food/' + id,
        method: "GET",
        success: data => {
            document.getElementById('food' + id).remove();
        }
    });
}