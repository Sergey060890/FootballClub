<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.jsp" %>
<h3>Player editing</h3>
    <jsp:useBean id="player" scope="request" type="footballclub.entity.Player"/>
<form method="post">
    <input type="hidden" value="${id}" name="id" />

    <label>Name</label><br>
    <label>
        <input name="name" value="${name}"  required/>
    </label><br><br>

    <label>Surname</label><br>
    <label>
        <input name="surname" value="${surname}"  required/>
    </label><br><br>

    <label>cтрана </label><br>
    <input name="country" value="${country}" /><br><br>

    <label>стадион </label><br>
    <input name="age" value="${age}" /><br><br>

    <label>тренер </label><br>
    <input name="position" value="${position}" /><br><br>

    <input type="submit" value="SAVE" />
</form>
<a class="gradient-button1" href="playerLineUp?id=${player.teamPlayer.team_id}" />BACK</a>
</body>
</html>