$(document).ready(() => fetchAllUsers())

function fetchAllUsers() {

    $.getJSON("api/admin/fetchAllUsers",
        data => {
            let user = '';

            $.each(data, (key, value) => {
                user +=
                    '<tr>' +
                    '    <td>' + value['userID'] + '</td> ' +
                    '    <td>' + value['username'] + '</td> ' +
                    '    <td>' + value['email'] + '</td> ' +
                    '    <td>' + value['spent'] + '</td> ' +
                    '    <td> ';
                user += value['enabled'] === true
                    ? '        <a  id="user' + value['userID'] + '" class="green-text" onclick="' + 'disableUser(' + value['userID'] + ')">Disable</a> '
                    : '        <a  id="user' + value['userID'] + '" class="red-text" onclick="' + 'enableUser(' + value['userID'] + ')">Enable</a> ';
                user +=
                    '    </td>' +
                    '</tr>';
            })

            $('#users-table').append(user);
        }
    )
}

function disableUser(id) {

    $.ajax({
        url: 'api/admin/disableUser/' + id,
        method: "GET",
        success: data => changeText(id)
    });
}

function enableUser(id) {

    $.ajax({
        url: 'api/admin/enableUser/' + id,
        method: "GET",
        success: data => changeText(id)
    });
}

function changeText(id) {

    let element = document.getElementById('user' + id);

    if (element.innerText === 'Enable') {
        element.innerText = 'Disable';
        element.classList.remove('red-text');
        element.classList.add('green-text');
    } else {
        element.innerText = 'Enable';
        element.classList.remove('green-text');
        element.classList.add('red-text')
    }
}