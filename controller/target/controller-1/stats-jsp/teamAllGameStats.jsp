<%--
  Created by IntelliJ IDEA.
  User: Сергей Медвецкий
  Date: 20.06.2022
  Time: 23:59
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

<jsp:useBean id="setGame" scope="request" type="java.util.Set"/>


<h2>All results</h2>
<table border="3" width="50%">
    <tr>
        <th>Opponent</th>
        <th>Result</th>
        <th>Score</th>
        <th>Yellow card</th>
        <th>Red card</th>
    </tr>
    <c:forEach var="game" items="${setGame}">
        <tr>
            <td>
                    ${game.opponent_name}
            </td>

            <td>
                    ${game.result}
            </td>

            <td>
                    ${game.goal_score}:${game.goals_conceded}
            </td>

            <td>
                    ${game.yellow_card_score}
            </td>

            <td>
                    ${game.red_card_score}
            </td>
        </tr>
    </c:forEach>
</table>

<a class="gradient-button1" href="statsTeam?id=${id}">BACK</a>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>

