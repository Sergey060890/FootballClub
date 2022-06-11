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
            <th>Surname</th>
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
                        ${player.player_surname}
                </td>

            </tr>
        </c:forEach>

    </table>


</center>
</body>
</html>