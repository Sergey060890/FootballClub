
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Добавление игрока</title>
</head>
<body>
<%@include file="headerTeam.jsp" %>
<h3>Добавить игрока</h3>
<form method="post">
    <br>
    <input name="name" required placeholder="Введите имя" style="width: 250px;"/><br><br>
    <input name="surname" placeholder="Введите фамилию" style="width: 250px;" /><br><br>
    <input name="contrary" placeholder="Введите страну" style="width: 250px;" /><br><br>
    <input name="age" placeholder="Введите возраст" style="width: 250px;" /><br><br>
    <input name="position" placeholder="Введите позицию" style="width: 250px;" /><br><br>
    <input type="submit"  value="Создать" />
</form>
<a href="TeamServlet">Вернуться назад</a>
</body>
</html>
