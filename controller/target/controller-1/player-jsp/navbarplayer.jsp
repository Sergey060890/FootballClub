<%--
  Created by IntelliJ IDEA.
  User: Пользователь
  Date: 14.06.2022
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Navbar player</title>
</head>
<body>
<jsp:useBean id="player" scope="request" type="footballclub.entity.Player"/>
<td>
    ${player.player_surname}
</td>
</body>
</html>
