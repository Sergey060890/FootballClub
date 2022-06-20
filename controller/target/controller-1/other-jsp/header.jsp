<%--
  Created by IntelliJ IDEA.
  User: Сергей Медвецкий
  Date: 25.05.2022
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link href="css/button-small.css" rel="stylesheet">
<link href="css/button.css" rel="stylesheet">
<link href="css/top.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link href="css/table.css" rel="stylesheet">
<link href="css/center.css" rel="stylesheet">
<style>
    a:link {
        text-decoration: none;
    }
</style>
<body>
<div class="topnav">
    <a class="active" href="StartServlet">Main page</a>
    <a href='<c:url value="game?id=${id}" />'>Play games</a>
    <a href='<c:url value="playerLineUp?id=${id}" />'>Team line-up</a>
    <a href='<c:url value="statsTeam?id=${id}" />'>Team statistics</a>
</div>
</body>
</html>
