<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="/other-jsp/headerTeam.jsp" %>
<center>
    <h3>Game editing</h3>
</center>
<jsp:useBean id="game" scope="request" type="footballclub.entity.Game"/>
<form method="post">
    <center>
        <input type="hidden" value="${id}" name="id"/>

        <label>Opponent</label><br>
        <label>
            <input name="opponent" value="${opponent}" required/>
        </label><br><br>

        <input type="submit" class="gradient-button1" value="SAVE"/>
        <a class="gradient-button1" href="game?id=${game.teamGame.team_id}"/>BACK</a>
    </center>
</form>
</body>
</html>