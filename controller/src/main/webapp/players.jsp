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
<%@include file="header.jsp" %>
<center>
    <h2>Состав</h2>
    <table border="3" width="50%">
        <tr>
            <th>Имя</th>
            <th>Фамилия</th>
            <th>Страна</th>
            <th>Возраст</th>
            <th>Позиция</th>
            <th colspan="3">Действия</th>
        </tr>

        <jsp:useBean id="players" scope="request" type="java.util.List"/>
        <c:forEach var="player" items="${players}">
            <tr>
                <td>${player.player_name}</td>
                <td>${player.player_surname}</td>
                <td>${player.country}</td>
                <td>
                    <center>
                        ${player.age}
                    </center>
                </td>
                <td>
                    </center>
                        ${player.position}</td>
                    </center>
                <td>


                    <a class="gradient-button" href='<c:url value="selection?id=${team.team_id}" />'>Выбрать</a>

                </td>

                <td>

                    <a class="gradient-button" href='<c:url value="edit?id=${team.team_id}" />'>Редактировать</a>

                </td>

                <td>

                    <a class="gradient-button" href='<c:url value="deletePlayer?id=${player.player_id}" />'>Удалить</a>

                </td>
            </tr>
        </c:forEach>

    </table>
    <a class="gradient-button1" href="createPlayer">Добавить игрока</a>

    <a class="gradient-button1" href="TeamServlet">Назад</a>

</center>
</body>
</html>

