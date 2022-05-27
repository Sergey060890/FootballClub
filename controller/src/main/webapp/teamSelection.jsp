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
    <table border="3" width="50%">

        <caption><b>Мой клуб</b></caption>
        <tr>
            <th>Название</th>
            <th>Состав</th>
            <th>Игры</th>
            <th colspan="2">Действия</th>
        </tr>

        <jsp:useBean id="name" scope="request" type="java.lang.String"/>
<%--        <c:forEach var="name" items="${name}">--%>

<%--        <jsp:useBean id="teams" scope="request" type="java.util.Set"/>--%>
<%--        <c:forEach var="team" items="${teams}">--%>

<%--        <jsp:useBean id="games" scope="request" type="java.util.Set"/>--%>
<%--        <c:forEach var="game" items="${games}">--%>

            <tr>
                <td>
                        ${name}
                </td>

                <td>
                    <a class="gradient-button" href='<c:url value="player?id=${team.team_id}" />'>Состав</a>
                </td>

                <td>
                    <a class="gradient-button" href='<c:url value="selection?id=${team.team_id}" />'>Игры</a>
                </td>

            </tr>
<%--        </c:forEach>--%>

    </table>

    <a class="gradient-button1" href="TeamServlet">Назад</a>

</center>
</body>
</html>
