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
<h3>Choice of starting lineup</h3>
</center>
<jsp:useBean id="id" scope="request" type="java.lang.Integer"/>
<jsp:useBean id="game" scope="request" type="footballclub.entity.Game"/>
<jsp:useBean id="players" scope="request" type="java.util.Set"/>

<form method="post">
    <center>

    <input type="hidden" value="${id}" name="id" />
<%--    <select name="select" size="15" multiple>--%>
<%--        <c:forEach var="player" items="${players}">--%>
<%--            <option>${player.player_surname}</option>--%>
<%--        </c:forEach>--%>
<%--    </select>--%>
    <c:forEach var="player" items="${players}">
        <input type="checkbox" name="player" value=${player.player_surname} unchecked />${player.player_surname}
        <br>
    </c:forEach>

    <input type="submit" value="SAVE" />
    </center>
</form>
<%--<p class="fig"><img src="image/Football.png"--%>
<%--                    width="600" height="600" ></p>--%>
<center>
<a class="gradient-button1" href="match?id=${id}" />BACK</a>
</center>
</body>
</html>