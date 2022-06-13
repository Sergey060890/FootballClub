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

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
            integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
            crossorigin="anonymous"></script>
<body style="background: url(image/pexelsphoto1594932.jpeg)">
<%@include file="/other-jsp/headerTeam.jsp" %>
<center>
    <h2>Team management</h2>
    <table>
        <tr>
            <th>Team name</th>
            <th>City</th>
            <th>
                <center>Actions</center>
            </th>
        </tr>
        <jsp:useBean id="teams" scope="request" type="java.util.List"/>
        <c:forEach var="team" items="${teams}">
            <tr>
                <td>${team.team_name}</td>
                <td>${team.city}</td>
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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>

