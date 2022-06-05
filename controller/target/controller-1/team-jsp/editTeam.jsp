<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<%@include file="/other-jsp/headerTeam.jsp" %>
<center>
<h2>
    Team editing
</h2>
</center>
<form method="post">
    <jsp:useBean id="id" scope="request" type="java.lang.Integer"/>
    <center>
    <input type="hidden" value="${team.id}" name="id" />

    <label>name</label><br>
    <label>
        <input name="name" value="${name}"  required/>
    </label><br><br>


    <label>city </label><br>
    <input name="city" value="${city}" /><br><br>

    <label>country </label><br>
    <input name="country" value="${country}" /><br><br>

    <label>stadium </label><br>
    <input name="stadium" value="${stadium}" /><br><br>

    <label>coach </label><br>
    <input name="coach" value="${coach}" /><br><br>

        <input type="submit" class="gradient-button1" value="SAVE" />
        <a class="gradient-button1" href="player?id=${id}" />BACK</a>
    </center>
</form>
</body>
</html>
