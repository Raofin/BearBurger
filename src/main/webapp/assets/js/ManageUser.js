$(document).ready(() => fetchAllUsers())

function fetchAllUsers() {

    $.getJSON("api/admin/fetchAllUsers",
        data => {
            let user = '';

            $.each(data, (key, value) => {
                user +=
                    '<tr id="row-user-' + value['userID'] + '">' +
                    '    <td>' + value['userID'] + '</td> ' +
                    '    <td>' + value['username'] + '</td> ' +
                    '    <td>' + value['email'] + '</td> ' +
                    '    <td>' + value['spent'] + ' tk</td> ' +
                    '    <td> ';
                user += value['enabled'] === true
                    ? '        <a  id="user' + value['userID'] + '" class="tomato-text" onclick="' + 'changeStatus(' + value['userID'] + ')">Disable</a> '
                    : '        <a  id="user' + value['userID'] + '" class="green-text" onclick="' + 'changeStatus(' + value['userID'] + ')">Enable</a> ';
                user +=
                    '    </td>' +
                    '    <td><a class="red-text" onclick="' + 'deleteUser(' + value['userID'] + ')">Delete</a></td>' +
                    '</tr>';
            })

            $('#users-table').append(user);
        }
    )
}

function deleteUser(id) {

    $.ajax({
        url: 'api/admin/deleteUserById/' + id,
        method: "GET",
        success: $('#row-user-' + id).remove()
    });
}

function changeStatus(id) {
    let element = document.getElementById('user' + id);

    if (element.innerText === 'Enable') {
        $.get('api/admin/enableUser/' + id);
        element.innerText = 'Disable';
        element.classList.remove('green-text');
        element.classList.add('tomato-text');
    } else {
        $.get('api/admin/disableUser/' + id);
        element.innerText = 'Enable';
        element.classList.remove('tomato-text');
        element.classList.add('green-text');
    }
}