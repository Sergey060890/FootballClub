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

        <caption><b>My upcoming games</b></caption>
        <tr>
            <th>Opponent</th>
            <th colspan="3">
                <center>Actions</center>
            </th>
        </tr>
        <%--        <jsp:useBean id="gameplay" scope="request" type="footballclub.entity.Game"/>--%>
        <jsp:useBean id="id" scope="request" type="java.lang.Integer"/>
        <jsp:useBean id="games" scope="request" type="java.util.Set"/>
        <c:forEach var="game" items="${games}">

            <tr>

                <td>
                        ${game.opponent_name}
                </td>

                <td>
                    <a class="gradient-button" href='<c:url value="match?id=${game.game_id}" />'>Play a match</a>
                </td>

                <td>
                    <a class="gradient-button" href='<c:url value="editGame?id=${game.game_id}" />'>Edit game</a>
                </td>

                <td>
                    <a class="gradient-button" href='<c:url value="deleteGame?id=${game.game_id}" />'>Refuse to
                        play</a>
                </td>

            </tr>
        </c:forEach>

    </table>

    <a class="gradient-button1" href='<c:url value="createGame?id=${id}" />'>NEW GAME</a>
    <a class="gradient-button1" href='<c:url value="player?id=${id}" />'>BACK</a>

</center>
</body>
</html>
