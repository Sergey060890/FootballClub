<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Title</title>
<%--    <style type="text/css">--%>
<%--        P.fig {--%>
<%--            text-align: right; /* Выравнивание */--%>
<%--        }--%>
<%--    </style>--%>
</head>
<body>
<%@include file="/other-jsp/headerTeam.jsp" %>
<center>
<h2>Please select starting lineup!</h2>
</center>
<jsp:useBean id="id" scope="request" type="java.lang.Integer"/>
<jsp:useBean id="game" scope="request" type="footballclub.entity.Game"/>
<jsp:useBean id="players" scope="request" type="java.util.Set"/>

<form method="post">
    <center>
        <input type="hidden" value="${game.game_id}" name="id"/>

        <c:forEach var="player" items="${players}">
            <input type="checkbox" name="player" style="position: center "
                   value=${player.player_surname} unchecked/>${player.player_surname} ${player.position}
            <br>
        </c:forEach>
        <input type="submit" class="gradient-button1" value="GO!"/>
    </center>
</form>

<center>
    <a class="gradient-button1" href="match?id=${id}"/>BACK</a>
</center>
</body>
</html>
