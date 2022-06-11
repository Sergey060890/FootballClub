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
<h3>Please select starting lineup!</h3>
</center>
<jsp:useBean id="id" scope="request" type="java.lang.Integer"/>
<jsp:useBean id="game" scope="request" type="footballclub.entity.Game"/>
<jsp:useBean id="players" scope="request" type="java.util.Set"/>

<form method="post">
    <center>

        <input type="hidden" value="${id}" name="id"/>

<%--        <label for="pos">Goalkeeper</label>--%>
<%--        <select name="gk" id="pos" style="width: 140px;"/>--%>
<%--        <c:forEach var="player" items="${players}">--%>
<%--            <option>${player.player_surname}</option>--%>
<%--        </c:forEach>--%>
<%--        </select>--%>
<%--        <br><br>--%>

<%--        <label for="pos">Сentre-back</label>--%>
<%--        <select name="cb" id="pos" style="width: 140px;"/>--%>
<%--        <c:forEach var="player" items="${players}">--%>
<%--            <option>${player.player_surname}</option>--%>
<%--        </c:forEach>--%>
<%--        </select>--%>
<%--        <br><br>--%>

<%--        <label for="pos">Сentre-back</label>--%>
<%--        <select name="cb2" id="pos" style="width: 140px;"/>--%>
<%--        <c:forEach var="player" items="${players}">--%>
<%--            <option>${player.player_surname}</option>--%>
<%--        </c:forEach>--%>
<%--        </select>--%>
<%--        <br><br>--%>

<%--        <label for="pos">Left back</label>--%>
<%--        <select name="lb" id="pos" style="width: 140px;"/>--%>
<%--        <c:forEach var="player" items="${players}">--%>
<%--            <option>${player.player_surname}</option>--%>
<%--        </c:forEach>--%>
<%--        </select>--%>
<%--        <br><br>--%>

<%--        <label for="pos">Right back</label>--%>
<%--        <select name="rb" id="pos" style="width: 140px;"/>--%>
<%--        <c:forEach var="player" items="${players}">--%>
<%--            <option>${player.player_surname}</option>--%>
<%--        </c:forEach>--%>
<%--        </select>--%>
<%--        <br><br>--%>

<%--        <label for="pos">--%>
<%--            Right midfielder</label>--%>
<%--        <select name="rm" id="pos" style="width: 140px;"/>--%>
<%--        <c:forEach var="player" items="${players}">--%>
<%--            <option>${player.player_surname}</option>--%>
<%--        </c:forEach>--%>
<%--        </select>--%>
<%--        <br><br>--%>

<%--        <label for="pos">--%>
<%--            Left midfielder</label>--%>
<%--        <select name="lm" id="pos" style="width: 140px;"/>--%>
<%--        <c:forEach var="player" items="${players}">--%>
<%--            <option>${player.player_surname}</option>--%>
<%--        </c:forEach>--%>
<%--        </select>--%>
<%--        <br><br>--%>

<%--        <label for="pos">Central midfielder</label>--%>
<%--        <select name="cm" id="pos" style="width: 140px;"/>--%>
<%--        <c:forEach var="player" items="${players}">--%>
<%--            <option>${player.player_surname}</option>--%>
<%--        </c:forEach>--%>
<%--        </select>--%>
<%--        <br><br>--%>

<%--        <label for="pos">Left winger</label>--%>
<%--        <select name="lw" id="pos" style="width: 140px;"/>--%>
<%--        <c:forEach var="player" items="${players}">--%>
<%--            <option>${player.player_surname}</option>--%>
<%--        </c:forEach>--%>
<%--        </select>--%>
<%--        <br><br>--%>

<%--        <label for="pos">Right winger</label>--%>
<%--        <select name="rw" id="pos" style="width: 140px;"/>--%>
<%--        <c:forEach var="player" items="${players}">--%>
<%--            <option>${player.player_surname}</option>--%>
<%--        </c:forEach>--%>
<%--        </select>--%>
<%--        <br><br>--%>

<%--        <label for="pos">Forward</label>--%>
<%--        <select name="frw" id="pos" style="width: 140px;"/>--%>
<%--        <c:forEach var="player" items="${players}">--%>
<%--            <option>${player.player_surname}</option>--%>
<%--        </c:forEach>--%>
<%--        </select>--%>
<%--        <br><br>--%>

<%--        <br>--%>
<%--        <label for="pos">Goalkeeper</label>--%>
<%--        <select name="position" id="pos" style="width: 140px;"/>--%>
<%--        <option value="GK">GK</option>--%>
<%--        <option value="FRW">FRW</option>--%>
<%--        <option value="RW">RW</option>--%>
<%--        <option value="LW">LW</option>--%>
<%--        <option value="CM">CM</option>--%>
<%--        <option value="RM">RM</option>--%>
<%--        <option value="LM">LM</option>--%>
<%--        <option value="CD">CD</option>--%>
<%--        <option value="LD">LD</option>--%>
<%--        <option value="RD">RD</option>--%>
<%--        </select>--%>
<%--        <br><br>--%>
    <c:forEach var="player" items="${players}">
        <input type="checkbox" name="player" style="position: center" value=${player.player_surname} unchecked />${player.player_surname} ${player.position}
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
