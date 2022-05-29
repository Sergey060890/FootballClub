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
<%@ page import="servlet.TeamServlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored = "false" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>

<body>
<%@include file="headerTeam.jsp" %>
<center>
    <table border="3" width="50%">

        <caption><b>Мой cостав</b></caption>
        <tr>
            <th>Имя</th>
            <th>Фамилия</th>
            <th>Позиция</th>
            <th colspan="3">Действия</th>
        </tr>

        <jsp:useBean id="id" scope="request" type="java.lang.Integer"/>
        <jsp:useBean id="players" scope="request" type="java.util.Set"/>
                <c:forEach var="player" items="${players}">

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
                    ${player.position}
            </td>

            <td>
                <a class="gradient-button" href='<c:url value="createPlayer?id=${player.player_id}" />'>Информация</a>
            </td>

            <td>
                <a class="gradient-button" href='<c:url value="edit?id=${team.team_id}" />'>Редактировать</a>
            </td>

            <td>
                <a class="gradient-button" href='<c:url value="deletePlayer?id=${player.player_id}" />'>Удалить игрока</a>
            </td>

        </tr>
                </c:forEach>

    </table>

    <a class="gradient-button1" href='<c:url value="createPlayer?id=${id}" />'>Добавить игрока</a>
    <a class="gradient-button1" href="TeamServlet">Назад</a>

</center>
</body>
</html>