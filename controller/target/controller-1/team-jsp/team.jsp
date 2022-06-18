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
<%--
  Created by IntelliJ IDEA.
  User: Сергей Медвецкий
  Date: 25.05.2022
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<html>

<head>
<body style="background: url(images/pexelsphoto1594932.jpeg)">
<%@include file="/other-jsp/headerTeam.jsp" %>
<center>
    <h2>My teams</h2>
    <table>
        <tr>
            <th>Team name</th>
            <th>City</th>
            <th colspan="1"></th>
        </tr>
        <jsp:useBean id="teams" scope="request" type="java.util.List"/>
        <c:forEach var="team" items="${teams}">
            <tr>
                <td>${team.team_name}</td>
                <center><td>${team.city}</td> </center>
                <center>
                    <td>
                        <a class="gradient-button" href='<c:url value="player?id=${team.team_id}" />'>SELECT</a>
                    </td>
                </center>
            </tr>
        </c:forEach>

    </table>
    <a class="gradient-button1" href="create">CREATE A TEAM</a>

    <a class="gradient-button1" href="StartServlet">BACK</a>

</center>
</body>
</html>

