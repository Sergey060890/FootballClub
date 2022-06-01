<%@ page import="footballclub.entity.Team" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Set" %>
<%@ page import="footballclub.entity.Player" %>
<%@ page import="footballclub.entity.Game" %>
<%@ page import="servlet.TeamServlet" %>
<%@ page import="servlet.SelectionTeamServlet" %>
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
    <table border="3" width="50%">

        <caption align="left">MY CLUB</caption>
        <tr>
            <th>NAME</th>
            <th>CITY</th>
            <th>COUNTRY</th>
            <th>STADIUM</th>
            <th>COACH</th>
<%--            <th colspan="2">Действия</th>--%>
        </tr>

        <jsp:useBean id="id" scope="request" type="java.lang.Integer"/>
        <jsp:useBean id="name" scope="request" type="java.lang.String"/>
        <jsp:useBean id="city" scope="request" type="java.lang.String"/>
        <jsp:useBean id="country" scope="request" type="java.lang.String"/>
        <jsp:useBean id="stadium" scope="request" type="java.lang.String"/>
        <jsp:useBean id="coach" scope="request" type="java.lang.String"/>
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
                ${city}
            </td>

            <td>
                ${country}
            </td>

            <td>
                ${stadium}
            </td>

            <td>
                ${coach}
            </td>

        </tr>
        <%--        </c:forEach>--%>

    </table>
    <a class="gradient-button1" href='<c:url value="game?id=${id}" />'>PLAY</a>
    <a class="gradient-button1" href='<c:url value="playerLineUp?id=${id}" />'>Team line-up</a>
    <a class="gradient-button1" href="TeamServlet">Team statistics</a>
    <a class="gradient-button1" href="TeamServlet">Back</a>
</center>
</body>
</html>
