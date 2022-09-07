$(document).ready(() => fetchAllUsers())

function fetchAllUsers() {

    $.getJSON("api/v1/admin/fetch-all-users",
        data => {
            let user = '';
            console.log(data);

            $.each(data, (key, value) => {
                let admin = value['userRoles'].length !== 1;
                user +=
                    '<tr>' +
                    '    <td>' + value['userID'] + '</td> ' +
                    '    <td>' + value['username'] + '</td> ' +
                    '    <td>' + value['email'] + '</td> ' +
                    '    <td id="role' + value['userID'] + '">' + titleCase(value['userRoles'][0]['role']);
                if (admin) user += ', ' + titleCase(value['userRoles'][1]['role']);
                user += '    </td> ';
                user += admin === true
                    ? '        <td><a  id="user' + value['userID'] + '" class="tomato-text" onclick="' + 'modifyRole(' + value['userID'] + ')">Remove Admin</a></td>'
                    : '        <td><a  id="user' + value['userID'] + '" class="green-text" onclick="' + 'modifyRole(' + value['userID'] + ')">Add Admin</a></td>'
            })

            $('#users-table').append(user);
        }
    )
}

function modifyRole(id) {

    let actionElement = document.getElementById('user' + id);
    let roleElement = document.getElementById('role' + id);

    if (actionElement.innerText === 'Remove Admin') {
        $.get('api/v1/admin/remove-admin/' + id);
        actionElement.innerText = 'Add Admin';
        actionElement.classList.remove('tomato-text');
        actionElement.classList.add('green-text');
        roleElement.innerHTML = 'Customer';
    } else {
        $.get('api/v1/admin/make-admin/' + id);
        actionElement.innerText = 'Remove Admin';
        actionElement.classList.remove('green-text');
        actionElement.classList.add('tomato-text');
        roleElement.innerHTML = 'Customer, Admin';
    }
}

function titleCase(str) {
    return str.toLowerCase().replace(/(^|\s)\S/g, L => L.toUpperCase());
}