<%--
  Created by IntelliJ IDEA.
  User: Пользователь
  Date: 27.05.2022
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="footballclub.entity.Team" %>
<%@ page import="java.util.List" %>
<%@ page import="DTO.TeamDTO" %>
<%@ page import="java.util.Set" %>
<%@ page import="footballclub.entity.Player" %>
<%@ page import="footballclub.entity.Game" %>
<%@ page import="servlet.teamServlet.TeamServlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>

<body>
<%@include file="/other-jsp/headerTeam.jsp" %>
<center>
    <table border="3" width="50%">
        <jsp:useBean id="id" scope="request" type="java.lang.Integer"/>
        <jsp:useBean id="info" scope="request" type="java.util.List"/>
        <jsp:useBean id="game" scope="request" type="footballclub.entity.Game"/>
        <%--        <jsp:useBean id="players" scope="request" type="java.util.Set"/>--%>

        <caption><b>${game.teamGame.team_name} VS ${game.opponent_name}</b></caption>
        <tr>
            <th>
                <center>GAME PROGRESS:</center>
            </th>
        </tr>

        <c:forEach var="info" items="${info}">

            <tr>
                <td>
                    <center>${info}</center>
                </td>

            </tr>
        </c:forEach>
        <tr>
            <th>
                <center>RESULT:</center>
            </th>
        </tr>
        <tr>
            <td>
                <center>${game.result} ${game.goal_score}:${game.goals_conceded}</center>
            </td>

        </tr>

    </table>

    <a class="gradient-button1" href="TeamServlet" />EXIT</a>
</center>
</body>
</html>