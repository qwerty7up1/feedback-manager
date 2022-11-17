<html lang="en">
<head>
    <link rel="icon" type="image/x-icon" href="/favicon.jpg">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <title>Профиль пользователя</title>


    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">

    <nav style="--bs-breadcrumb-divider: '';" aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="/login">Login</a></li>
            <li class="breadcrumb-item"><a href="/admin">Admin</a></li>
            <li class="breadcrumb-item"><a href="/profile">User</a></li>
        </ol>
    </nav>

</head>

<body>


<script>
    function editMessage(id) {
        $('#message-text-' + id).hide();
        $('#edit-button-' + id).hide();
        $('#cancel-button-' + id).show();
        $('#edit-message-' + id).show();
    }

    function cancelEdit(id) {
        $('#message-text-' + id).show();
        $('#edit-button-' + id).show();
        $('#cancel-button-' + id).hide();
        $('#edit-message-' + id).hide();
    }

</script>

<h1>Профиль пользователя</h1>
<h2>${user.firstName} ${user.lastName}</h2>
<div class="row">
    <div class="col-sm-6">

        <form action="/login" method="post">
            <input type="submit" value="Выйти из профиля">
        </form>

        <#list user.messages as message>

            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">${message.publicationTime}</h5>
                    <p id="message-text-${message.id}" class="card-text">${message.text}</p>

                    <form id="edit-message-${message.id}" action="/profile/edit-message/${message.id}" method="post">
                        <textarea name="text" rows="1" cols="50">${message.text}</textarea>
                        <input class="btn btn-success" type="submit" value="Сохранить">
                    </form>

                    <form action="/profile/delete-message/${message.id}" method="post">
                        <input class="btn btn-success" type="submit" value="Удалить">
                    </form>
                    <input class="btn btn-success" type="button" id="edit-button-${message.id}" value="Изменить" onclick="editMessage(${message.id})">
                    <input class="btn btn-success" type="button" id="cancel-button-${message.id}" value="Отменить" onclick="cancelEdit(${message.id})">

                </div>
            </div>

            <script>
                cancelEdit(${message.id})
            </script>
        </#list>

        <div class="col-sm-6">
        </div>



        <form action="/profile/new-message" method="post">
            <label for="add-new-message">Добавить новое сообщение:</label>

            <textarea id="add-new-message" name="text" rows="4" cols="50"></textarea>

            <input type="submit" value="Отправить">
        </form>
</body>

</html>