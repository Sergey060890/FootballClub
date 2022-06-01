<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.jsp" %>
<h3>Game editing</h3>
<jsp:useBean id="game" scope="request" type="footballclub.entity.Game"/>
<form method="post">

    <input type="hidden" value="${id}" name="id" />

    <label>Date</label><br>
    <label>
        <input name="date" value="${date}"  required/>
    </label><br><br>

    <label>Opponent</label><br>
    <label>
        <input name="opponent" value="${opponent}"  required/>
    </label><br><br>

    <input type="submit" value="SAVE" />
</form>
<a class="gradient-button1" href="game?id=${game.teamGame.team_id}" />BACK</a>
</body>
</html>