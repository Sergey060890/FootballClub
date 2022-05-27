
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
<%@include file="headerTeam.jsp" %>
<center>
    <h2>Управление командами</h2>
    <table border="3" width="50%">
        <tr>
            <th>Название</th>
            <th>Город</th>
            <th>Страна</th>
            <th>Стадион</th>
            <th>Тренер</th>
            <th colspan="3">Действия</th>
        </tr>

            <jsp:useBean id="teams" scope="request" type="java.util.List"/>
            <c:forEach var="team" items="${teams}">
        <tr>
            <td>${team.team_name}</td>
            <td>${team.city}</td>
            <td>${team.country}</td>
            <td>${team.stadium}</td>
            <td>${team.coach}</td>

            <td>
                <a class="gradient-button" href='<c:url value="selection?id=${team.team_id}" />'>Информация</a>
            </td>

            <td>
                <a class="gradient-button" href='<c:url value="edit?id=${team.team_id}" />'>Редактировать</a>
            </td>

            <td>
                <a class="gradient-button" href='<c:url value="delete?id=${team.team_id}" />'>Удалить</a>
            </td>
        </tr>
</c:forEach>

    </table>
    <a class="gradient-button1" href="create">Создать команду</a>

    <a class="gradient-button1" href="index.jsp">Назад</a>

</center>
</body>
</html>

