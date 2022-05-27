<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Создание команд</title>
</head>
<body>
<%@include file="headerTeam.jsp" %>
<h3>Добавить команду</h3>
<form method="post">
    <br>
    <input name="name" required placeholder="Введите название" style="width: 250px;"/><br><br>
    <input name="city" placeholder="Введите город" style="width: 250px;" /><br><br>
    <input name="сountry" placeholder="Введите страну" style="width: 250px;" /><br><br>
    <input name="stadium" placeholder="Введите название стадиона" style="width: 250px;" /><br><br>
    <input name="coach" placeholder="Введите имя и фамилию тренера" style="width: 250px;" /><br><br>
    <input type="submit" value="Создать" />
</form>
<a href="team.jsp">Вернуться назад</a>
</body>
</html>
