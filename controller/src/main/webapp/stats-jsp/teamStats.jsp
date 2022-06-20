<%--
  Created by IntelliJ IDEA.
  User: Сергей Медвецкий
  Date: 20.06.2022
  Time: 21:17
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

<jsp:useBean id="team" scope="request" type="footballclub.entity.Team"/>

<jsp:useBean id="countGame" scope="request" type="java.lang.Integer"/>
<jsp:useBean id="countWinGame" scope="request" type="java.lang.Integer"/>
<jsp:useBean id="countDrawGame" scope="request" type="java.lang.Integer"/>
<jsp:useBean id="countLoseGame" scope="request" type="java.lang.Integer"/>
<jsp:useBean id="countGoalScore" scope="request" type="java.lang.Integer"/>
<jsp:useBean id="countGoalConceded" scope="request" type="java.lang.Integer"/>
<jsp:useBean id="countYellowCard" scope="request" type="java.lang.Integer"/>
<jsp:useBean id="countRedCard" scope="request" type="java.lang.Integer"/>


    <h3>${team.team_name} ${team.city} STATISTICS</h3>
    <table border="3" width="50%">
        <tr>
            <th>Total games</th>
            <th>WIN</th>
            <th>DRAW</th>
            <th>LOSE</th>
        </tr>

        <tr>
            <td>
                ${countGame}
            </td>

            <td>
                ${countWinGame}
            </td>

            <td>
                ${countDrawGame}
            </td>

            <td>
                ${countLoseGame}
            </td>
        </tr>
    </table>

    <h3>Detailed statistics</h3>
    <table border="3" width="50%">
        <tr>
            <th>Goals scored</th>
            <th>Goals conceded</th>
            <th>Total yellow cards</th>
            <th>Total red cards</th>
        </tr>

        <tr>
            <td>
                ${countGoalScore}
            </td>

            <td>
                ${countGoalConceded}
            </td>

            <td>
                <center>
                    <%--                    <div class="counter" data-count="150">${countYellowCard}</div>--%>
                    ${countYellowCard}
                </center>
            </td>

            <td>
                <center>
                    <%--                    <div class="counter2" data-count="150">${countRedCard}</div>--%>
                    ${countRedCard}
                </center>
            </td>
        </tr>
    </table>

    <a class="gradient-button1" href="statsAllGameTeam?id=${id}">LEARN MORE</a>
    <a class="gradient-button1" href="player?id=${id}">BACK</a>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>

