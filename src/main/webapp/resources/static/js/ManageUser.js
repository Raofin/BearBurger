$(document).ready(() => fetchAllUsers())

function fetchAllUsers() {

    $.getJSON("api/v1/admin/fetch-all-users",
        data => {
            let user = '';

            $.each(data, (key, value) => {
                user +=
                    '<tr id="row-user-' + value['userID'] + '">' +
                    '    <td>' + value['userID'] + '</td> ' +
                    '    <td>' + value['username'] + '</td> ' +
                    '    <td>' + value['email'] + '</td> ' +
                    '    <td>' + value['spent'] + ' tk</td> ' +
                    '    <td id="status-user-' + value['userID'] + '"> ';
                user += value['enabled'] === true ? 'Enabled</td><td>' : 'Disabled</td><td>';
                user += value['enabled'] === true
                    ? '        <a  id="user' + value['userID'] + '" class="tomato-text" onclick="' + 'changeStatus(' + value['userID'] + ')">Disable</a></td>'
                    : '        <a  id="user' + value['userID'] + '" class="green-text" onclick="' + 'changeStatus(' + value['userID'] + ')">Enable</a></td>';
                user += '<td><a class="red-text delete-col" onclick="' + 'deleteUser(' + value['userID'] + ')">Delete</a></td></tr>';
            })

            $('#users-table').append(user);
        }
    )
}

function deleteUser(id) {

    $.ajax({
        url: 'api/v1/admin/delete-user-by-id/' + id,
        method: "GET",
        success: $('#row-user-' + id).remove()
    });
}

function changeStatus(id) {
    let actionElement = document.getElementById('user' + id);
    let statusElement = document.getElementById('status-user-' + id);

    if (actionElement.innerText === 'Enable') {
        $.get('api/v1/admin/enable-user/' + id);
        actionElement.innerText = 'Disable';
        actionElement.classList.remove('green-text');
        actionElement.classList.add('tomato-text');
        statusElement.innerText = 'Enabled';
    } else {
        $.get('api/v1/admin/disable-user/' + id);
        actionElement.innerText = 'Enable';
        actionElement.classList.remove('tomato-text');
        actionElement.classList.add('green-text');
        statusElement.innerText = 'Disabled';
    }
}