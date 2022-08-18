document.addEventListener('load', fetch('Burger'));

function fetch(category) {
    const foodsTable = document.getElementById("foods-table");
    const xhr = new XMLHttpRequest();

    xhr.open("GET", "../models/Foods.php?cat=" + category);
    xhr.onload = function () {
        foodsTable.innerHTML = '';
        foodsTable.innerHTML = this.responseText;
    }
    xhr.send();

    $('label').removeClass('white-back-text');
    $('#' + category).addClass('white-back-text');
}
