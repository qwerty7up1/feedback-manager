<html lang="en">
<head>
    <link rel="icon" type="image/x-icon" href="/favicon.jpg">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <title>Page registration user</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>

    <nav style="--bs-breadcrumb-divider: '';" aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="/profile">Profile</a></li>
            <li class="breadcrumb-item active" aria-current="/registration">registration</li>
        </ol>
    </nav>

    <style>
        input, select {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        /* Style the submit button */
        input[type=submit] {
            width: 100%;
            background-color: #04AA6D;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        /* Add a background color to the submit button on mouse-over */
        input[type=submit]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

<div style="width: 500px; margin-left: 30%;">
    <h1>Регистрация</h1>
    <form action="/register" method="post">

        <label for="firstname-input" >Имя</label>
        <input name="firstName" id="firstname-input" type="text" />

        <label for="lastname-input" >Фамилия</label>
        <input name="lastName" id="lastname-input" type="text" />

        <label for="email-input" >Почта</label>
        <input name="email" id="email-input" type="text" />

        <label for="date-input" >Дата рождения</label>
        <input name="dateOfBirth" id="date-input" type="date" />

        <label for="password-input" >Придумайте пароль</label>
        <input name="password" id="password-input" type="password" />

        <input type="submit" value="Зарегистрироваться">
    </form>
    <form action="/profile" method="get">
        <input type="submit" value="Отмена">
    </form>
</div>


</body>

</html>