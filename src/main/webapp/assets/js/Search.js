const input = document.getElementById('search-box');

document.addEventListener('load', searchAndFetch(''));

input.addEventListener('input', () => searchAndFetch(input.value));
input.addEventListener('keypress', event => {
    if (event.key === 'Enter') event.preventDefault();
})

function searchAndFetch(foodTitle) {
    const foodsTable = document.getElementById("foods-table");
    const xhr = new XMLHttpRequest();

    xhr.open("GET", "../models/Foods.php?search=" + foodTitle);
    xhr.onload = function () {
        foodsTable.innerHTML = '';

        if (this.responseText === '')
            foodsTable.innerHTML = '<h3 style="color:tomato">' +
                'Sorry! "' + input.value + '" is not available.</h3>';
        else foodsTable.innerHTML = this.responseText;
    }
    xhr.send();
}