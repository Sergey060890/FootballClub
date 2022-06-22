<%--
  Created by IntelliJ IDEA.
  User: Сергей Медвецкий
  Date: 21.06.2022
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<link href="css/count.css" rel="stylesheet">
<link href="css/stats3.css" rel="stylesheet">
<link href="css/button-info.css" rel="stylesheet">
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
            integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
            crossorigin="anonymous"></script>

<body>

<%@include file="/other-jsp/headerTeam.jsp" %>

<jsp:useBean id="id" scope="request" type="java.lang.Integer"/>

<jsp:useBean id="player" scope="request" type="footballclub.entity.Player"/>

<jsp:useBean id="countGamePlayer" scope="request" type="java.lang.Integer"/>
<jsp:useBean id="countStartGamePlayer" scope="request" type="java.lang.Integer"/>
<jsp:useBean id="countGoalPlayer" scope="request" type="java.lang.Integer"/>
<jsp:useBean id="countGoalConcededPlayer" scope="request" type="java.lang.Integer"/>
<jsp:useBean id="countYellowCardPlayer" scope="request" type="java.lang.Integer"/>
<jsp:useBean id="countRedCardPlayer" scope="request" type="java.lang.Integer"/>


<h3>${player.player_name} ${player.player_surname} statistics:</h3>
<c:if test="${player.position=='GK'}">
    <table border="3" width="50%">

        <tr>
            <th>Total games</th>
            <th>In the starting lineup</th>
            <th>Heads missed</th>
            <th>Yellow cards</th>
            <th>Red cards</th>
        </tr>

        <tr>
            <td>
                    ${countGamePlayer}
            </td>

            <td>
                    ${countStartGamePlayer}
            </td>

            <td>
                    ${countGoalConcededPlayer}
            </td>

            <td>
                    ${countYellowCardPlayer}
            </td>

            <td>
                    ${countRedCardPlayer}
            </td>
        </tr>
    </table>
</c:if>
<c:if test="${player.position!='GK'}">
    <table border="3" width="50%">

        <tr>
            <th>Total games</th>
            <th>In the starting lineup</th>
            <th>Goals scored</th>
            <th>Yellow cards</th>
            <th>Red cards</th>
        </tr>

        <tr>
            <td>
                    ${countGamePlayer}
            </td>

            <td>
                    ${countStartGamePlayer}
            </td>

            <td>
                    ${countGoalPlayer}
            </td>

            <td>
                    ${countYellowCardPlayer}
            </td>

            <td>
                    ${countRedCardPlayer}
            </td>
        </tr>
    </table>
</c:if>
<table border="3" width="50%">

<%--<h3>Detailed statistics</h3>--%>
<%--<table border="3" width="50%">--%>
<%--    <tr>--%>
<%--        <th>Goals scored</th>--%>
<%--        <th>Goals conceded</th>--%>
<%--        <th>Total yellow cards</th>--%>
<%--        <th>Total red cards</th>--%>
<%--    </tr>--%>

<%--    <tr>--%>
<%--        <td>--%>
<%--            ${countGoalScore}--%>
<%--        </td>--%>

<%--        <td>--%>
<%--            ${countGoalConceded}--%>
<%--        </td>--%>

<%--        <td>--%>
<%--            <center>--%>
<%--                &lt;%&ndash;                    <div class="counter" data-count="150">${countYellowCard}</div>&ndash;%&gt;--%>
<%--                ${countYellowCard}--%>
<%--            </center>--%>
<%--        </td>--%>

<%--        <td>--%>
<%--            <center>--%>
<%--                &lt;%&ndash;                    <div class="counter2" data-count="150">${countRedCard}</div>&ndash;%&gt;--%>
<%--                ${countRedCard}--%>
<%--            </center>--%>
<%--        </td>--%>
<%--    </tr>--%>
<%--</table>--%>

<%--<a class="gradient-button1" href="statsAllGameTeam?id=${id}">LEARN MORE</a>--%>
<a class="gradient-button1" href="playerLineUp?id=${player.teamPlayer.team_id}">BACK</a>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
