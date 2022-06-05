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
<%@ page isELIgnored = "false" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>

<body>
<%@include file="/other-jsp/headerTeam.jsp" %>
<center>
    <table border="3" width="50%">

        <caption><b>My lineup</b></caption>
        <tr>
            <th>Name</th>
            <th>Surname</th>
            <th>Position</th>
            <th colspan="3"><center>Actions</center></th>
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
                <a class="gradient-button" href='<c:url value="informationPlayer?id=${player.player_id}" />'>INFORMATION</a>
            </td>

            <td>
                <a class="gradient-button" href='<c:url value="editPlayer?id=${player.player_id}" />'>EDIT</a>
            </td>

            <td>
                <a class="gradient-button" href='<c:url value="deletePlayer?id=${player.player_id}" />'>DELETE PLAYER</a>
            </td>

        </tr>
                </c:forEach>

    </table>

    <a class="gradient-button1" href='<c:url value="createPlayer?id=${id}" />'>ADD PLAYER</a>
    <a class="gradient-button1" href='<c:url value="player?id=${id}" />'>BACK</a>

</center>
</body>
</html>