<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<link href="css/woow.css" rel="stylesheet">
<head>
<%--    <style type="text/css">--%>
<%--        P.fig {--%>
<%--            text-align: right; /* Выравнивание */--%>
<%--        }--%>
<%--    </style>--%>
<%--<style>--%>
<%--    p {--%>
<%--font-family: Verdana, Arial, Helvetica, sans-serif;--%>
<%--font-size: 20pt; /* Размер шрифта в пунктах */--%>
<%--}--%>
<%--    </style>--%>
<body>
<%@include file="/other-jsp/headerTeam.jsp" %>
<center>
<h2>Please select starting lineup! (11 players)</h2>
</center>
<jsp:useBean id="id" scope="request" type="java.lang.Integer"/>
<jsp:useBean id="game" scope="request" type="footballclub.entity.Game"/>
<jsp:useBean id="players" scope="request" type="java.util.Set"/>


<header class="page-header">

    <main>
        <article id="hero-1" style="--i: 5">
            <div class="hero-info">
                <form method="post">
                    <center>

                        <input type="hidden" value="${game.game_id}" name="id"/>
                        <c:forEach var="player" items="${players}">
                            <input type="checkbox"  name="player"  style=" position: center "
                                   value=${player.player_surname} unchecked/> ${player.player_surname} ${player.position}
                            <br>
                        </c:forEach>
                        <input type="submit" class="gradient-button1" value="GO!"/>
                        <a class="gradient-button1" href="match?id=${id}"/>BACK</a>
                    </center>
                </form>
            </div>
            <div class="hero-image hi-2"></div>
        </article>

    </main>

</header>

<%--<form method="post">--%>
<%--    <center>--%>
<%--        --%>
<%--        <input type="hidden" value="${game.game_id}" name="id"/>--%>
<%--        <img src="images/football_player_PNG57.png" align="left" width="700" height="500" />--%>
<%--        <c:forEach var="player" items="${players}">--%>
<%--            <input type="checkbox" name="player"  style=" position: center "--%>
<%--                   value=${player.player_surname} unchecked/> ${player.player_surname} ${player.position}--%>
<%--            <br>--%>
<%--        </c:forEach>--%>
<%--        <input type="submit" class="gradient-button1" value="GO!"/>--%>
<%--    </center>--%>
<%--</form>--%>

<%--<center>--%>
<%--    <a class="gradient-button1" href="match?id=${id}"/>BACK</a>--%>
<%--</center>--%>
</body>
</html>
