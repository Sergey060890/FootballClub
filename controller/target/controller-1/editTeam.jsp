<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="headerTeam.jsp" %>
<h3>Редактирование команды</h3>

<form method="post">
    <input type="hidden" value="${team.id}" name="id" />

    <label>название</label><br>
    <label>
        <input name="name" value="${name}"  required/>
    </label><br><br>


    <label>город </label><br>
    <input name="city" value="${city}" /><br><br>

    <label>cтрана </label><br>
    <input name="country" value="${country}" /><br><br>

    <label>стадион </label><br>
    <input name="stadium" value="${stadium}" /><br><br>

    <label>тренер </label><br>
    <input name="coach" value="${coach}" /><br><br>

    <input type="submit" value="Сохранить" />
</form>
<a class="gradient-button" href="TeamServlet" />Вернуться назад</a>
</body>
</html>
