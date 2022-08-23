<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<c:import url="/templates/AdminHeader.jsp"/>
<head>

    <script>
        //         const xmlHttp = new XMLHttpRequest();
        //         const usersTable = document.getElementById("usersTableid");
        //
        //         xmlHttp.onreadystatechange = function () {
        //             if(xmlHttp.readyState === 4 && xmlHttp.status === 200){
        //                 console.log(usersTable.innerText)
        //             }
        //         }
        //         xmlHttp.open("GET","http://localhost:8080/spring_web_war_exploded/rest/users",true);
        //         xmlHttp.send();

        function renderUsers() {
            $.getJSON("http://localhost:8080/spring_web_war_exploded/api/fetchAllUsers",
                function (data) {
                    user='';
                    $.each(data,function (key,value) {
                        user += '<tr>';
                        user += '<td>' +
                            value.userID + '</td>';
                        user += '<td>' +
                            value.username + '</td>';
                        user += '<td>' +
                            value.email + '</td>';
                        user += '<td>' +
                            value.spent + '</td>';
                        user += '<td>' +
                            '<a onclick="disableRequest()" >Disable</a>' +
                            '<a onclick="deleteRequest()" >Delete</a>' +
                            '</td>';
                        user += '</tr>';

                    })
                    $("#usersTableid").append(user);
                    //$("#usersTableid").innerText=user;

                }
            )
        }
        function deleteRequest(email){

            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function() {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                    // users = '';
                    // users = renderUsers();
                    // $("#usersTableid").append(users);
                }
            }
            xmlhttp.open("GET", "http://localhost:8080/spring_web_war_exploded/rest/deleteUser?email=" + email, true);
            xmlhttp.send();
        }
        function disableRequest(id){
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function() {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                    // users = '';
                    // users = renderUsers();
                    // $("#usersTableid").append(users);
                }
            }
            xmlhttp.open("GET", "http://localhost:8080/spring_web_war_exploded/rest/disable?id=" + id, true);
            xmlhttp.send();
        }


        renderUsers();

    </script>

</head>
<div class="manage-user-container">
    <form id="register-form" method="POST">
        <h2 class="admin-form-title">Manage Users</h2>
        <div class="table-wrapper">
            <table id="usersTableid">
                <tr>
                    <th>UserID</th>
                    <th>Username</th>
                    <th>Email</th>
                    <th>Total Spent</th>
                    <th>Action</th>
                </tr>
            </table>


        </div>
    </form>

</div>

<%--<script src="<c:url value="/assets/js/.js"/>"></script>--%>
<c:import url="/templates/Footer.jsp"/>