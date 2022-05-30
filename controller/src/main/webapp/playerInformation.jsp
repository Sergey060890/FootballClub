<%@ page import="footballclub.entity.Team" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Set" %>
<%@ page import="footballclub.entity.Player" %>
<%@ page import="footballclub.entity.Game" %>
<%@ page import="servlet.TeamServlet" %>
<%@ page import="servlet.SelectionTeamServlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored = "false" %>
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

<body>
<%@include file="headerTeam.jsp" %>
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

        <%--        <c:forEach var="name" items="${name}">--%>

        <%--        <jsp:useBean id="teams" scope="request" type="java.util.Set"/>--%>
        <%--        <c:forEach var="team" items="${teams}">--%>

        <%--        <jsp:useBean id="games" scope="request" type="java.util.Set"/>--%>
        <%--        <c:forEach var="game" items="${games}">--%>

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
        <%--        </c:forEach>--%>

    </table>
    <a class="gradient-button1" href="TeamServlet">Games</a>
    <a class="gradient-button1" href="TeamServlet">Statistics</a>
    <a class="gradient-button1" href="playerLineUp?id=${player.teamPlayer.team_id}">Back</a>
</center>
</body>
</html>
