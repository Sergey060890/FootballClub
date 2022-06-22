<%@ page import="footballclub.entity.Team" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Set" %>
<%@ page import="footballclub.entity.Player" %>
<%@ page import="footballclub.entity.Game" %>
<%@ page import="servlet.teamServlet.TeamServlet" %>
<%@ page import="servlet.teamServlet.SelectionTeamServlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%--
  Created by IntelliJ IDEA.
  User: Сергей Медвецкий
  Date: 25.05.2022
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>

<body style="background: url(images/balls.jpeg)">
<%@include file="/other-jsp/headerTeam.jsp" %>
<center>
    <table border="3" width="50%">

        <caption align="left">Player information</caption>
        <tr>
            <th>NAME</th>
            <th>SURNAME</th>
            <th>COUNTRY</th>
            <th>AGE</th>
            <th>POSITION</th>
            <%--            <th colspan="2">Действия</th>--%>
        </tr>

        <jsp:useBean id="id" scope="request" type="java.lang.Integer"/>
        <jsp:useBean id="player" scope="request" type="footballclub.entity.Player"/>

        <tr>
            <td>
                ${player.player_name}
            </td>

            <td>
                ${player.player_surname}
            </td>

            <td>
                ${player.country}
            </td>

            <td>
                ${player.age}
            </td>

            <td>
                ${player.position}
            </td>

        </tr>

    </table>

    <a class="gradient-button1" href="statsPlayer?id=${player.player_id}">STATISTICS</a>
    <a class="gradient-button1" href="playerLineUp?id=${player.teamPlayer.team_id}">BACK</a>
<%--    <img src="images/player.png" align="left" width="700" height="500" />--%>
</center>
</body>
</html>
