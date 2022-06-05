<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Добавление игрока</title>
</head>
<body>
<%@include file="/other-jsp/headerTeam.jsp" %>
<center>
<h3>Adding a Player</h3>
</center>
<jsp:useBean id="id" scope="request" type="java.lang.Integer"/>
<form method="post">
    <center>
    <br>
    <input name="name" required placeholder="Enter your name" style="width: 250px;"/><br><br>
    <input name="surname" placeholder="Enter last name" style="width: 250px;"/><br><br>
    <input name="contrary" placeholder="Enter country" style="width: 250px;"/><br><br>
    <input name="age" placeholder="Enter age" style="width: 250px;"/><br><br>
    <input name="position" placeholder="Enter position" style="width: 250px;"/><br><br>
    <input type="submit" class="gradient-button1" value="ADD"/>
        <a class="gradient-button1" href="playerLineUp?id=${id}" />BACK</a>
    </center>
</form>
</body>
</html>
