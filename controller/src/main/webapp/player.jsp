<%--
  Created by IntelliJ IDEA.
  User: Пользователь
  Date: 27.05.2022
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>

<body>
<%@include file="headerTeam.jsp" %>
<center>
    <table border="3" width="50%">

        <caption><b>Мой cостав</b></caption>
        <tr>
            <th>Имя</th>
            <th>Фамилия</th>
            <th>Позиция</th>
            <th colspan="3">Действия</th>
        </tr>

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
                <a class="gradient-button" href='<c:url value="selection?id=${team.team_id}" />'>Выбрать</a>
            </td>

            <td>
                <a class="gradient-button" href='<c:url value="edit?id=${team.team_id}" />'>Редактировать</a>
            </td>

            <td>
                <a class="gradient-button" href='<c:url value="delete?id=${team.team_id}" />'>Удалить игрока</a>
            </td>

        </tr>
                </c:forEach>

    </table>

    <a class="gradient-button1" href="teamSelection.jsp">Добавить игрока</a>

    <a class="gradient-button1" href="teamSelection.jsp">Назад</a>

</center>
</body>
</html>