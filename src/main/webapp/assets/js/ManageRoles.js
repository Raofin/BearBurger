$(document).ready(() => fetchAllUsers())

function fetchAllUsers() {

    $.getJSON("api/admin/fetchAllUsers",
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
                // user += '    </td> ';
                /*user += value['userRoles'].length === 2
                    ? ', '+ titleCase(value['userRoles'][1]['role']) : '';
                user += '    </td> ';*/
            })

            $('#users-table').append(user);
        }
    )
}

/*function removeAdmin(id) {

    $.ajax({
        url: 'api/admin/removeAdmin/' + id,
        method: "GET",
        success: changeText(id)
    });
}

function addAdmin(id) {

    $.ajax({
        url: 'api/admin/makeAdmin/' + id,
        method: "GET",
        success: changeText(id)
    });
}*/

function modifyRole(id) {

    let actionElement = document.getElementById('user' + id);
    let roleElement = document.getElementById('role' + id);

    if (actionElement.innerText === 'Remove Admin') {
        $.get('api/admin/removeAdmin/' + id);
        actionElement.innerText = 'Add Admin';
        actionElement.classList.remove('tomato-text');
        actionElement.classList.add('green-text');
        roleElement.innerHTML = 'Customer';
    } else {
        $.get('api/admin/makeAdmin/' + id);
        actionElement.innerText = 'Remove Admin';
        actionElement.classList.remove('green-text');
        actionElement.classList.add('tomato-text');
        roleElement.innerHTML = 'Customer, Admin';
    }
}

function titleCase(str) {
    return str.toLowerCase().replace(/(^|\s)\S/g, L => L.toUpperCase());
}