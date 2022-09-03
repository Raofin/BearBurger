function writeFoodHtml(data) {
    let foodHtml = "";
    let foodTable = document.getElementById('foods-table');

    foodTable.innerHTML = "";

    for (let i = 0; i < data.length; i++) {

        foodHtml += "" +
            "<td>\n" +
            "    <div class=\"food-box\">\n" +
            "        <h2>" + data[i]['title'] + "</h2>\n" +
            "        <p>" + data[i]['description'] + "</p>\n" +
            "        <p class=\"food-price\">Price: " + data[i]['price'] + "tk</p>\n" +
            "        <div class='food-container-buttons'>\n" +
            "            <a href=\"./payment?foodId=" + data[i]['foodID'] + "\"><button type=\"button\" class=\"button\">Buy</button></a>\n" +
            "            <a href=\"./comments/" + data[i]['foodID'] + "\"><button type=\"button\" class=\"button\">Comment</button></a>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</td>\n";

        foodTable.innerHTML = foodHtml;
    }
}